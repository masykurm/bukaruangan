package bl.core.telegram.rest;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.ApiContext;
import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import bl.core.hackathon.model.BookedRoom;
import bl.core.hackathon.rest.RoomService;

@EnableScheduling
@Component
public class TelegramWebhook {
	
	@Value("${telegram.bot.token}")
	private String telegramBotToken;
	
	@Value("${telegram.bot.name}")
	private String telegramBotName;
	

	@Value("${telegram.bot.max-thread}")
	private int telegramMaxThread;
	
	@Value("${telegram.bot.max-conn}")
	private int telegramMaxWebHookConn;
	
	@Autowired
	private RoomService roomService;
	
	private final static Logger logger = Logger.getLogger(TelegramWebhook.class.getName());

	@PostConstruct
	public void init() {
		DefaultBotOptions options = new DefaultBotOptions();
		options.setMaxThreads(telegramMaxThread); // Max threads sender
		// asynchronous
		options.setMaxWebhookConnections(telegramMaxWebHookConn); // Maximum
		// web
		// hook
		// connection
		bot = new TelegramBot(options);
	}
	
	
//	@Scheduled(fixedRate=20000)
	public void sendMeetingReminder() {
		
		logger.info("Running meeting reminder job");
		List<BookedRoom> nearestMeeting = roomService.getNearestMeeting();
		
		nearestMeeting.parallelStream().forEach(meeting ->{
			logger.info("Sending reminder to "+ meeting.getBookedBy());
			
			String message = String.format("Hi %s, kamu ada meeting %s pada %s:%s jangan lupa ya",
					meeting.getBookedBy(),
					meeting.getMeetingName(),
					meeting.getBookedStartDate().getHour(),
					meeting.getBookedStartDate().getMinute());
			
			try {
				replyTextMessage(meeting.getBookedBy(), message);
			} catch (TelegramApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		logger.info("Done running meeting reminder job");
	}
	 

	private void replyTextMessage(String userId, String message) throws TelegramApiException {
		long current = System.currentTimeMillis();
		SendMessage messageReturn = new SendMessage();
		messageReturn.setChatId(userId);
		messageReturn.setText(message.replaceAll("\\n", "\n"));
		
		

		ReplyKeyboardRemove removekeyboard = new ReplyKeyboardRemove();
		messageReturn.setReplyMarkup(removekeyboard);
		// bot.sendMessage(messageReturn);
		sendToTelegram(messageReturn);

		long now = System.currentTimeMillis();
		logger.info(String.format(
				"done replying text message processing-time: %d ms", (now - current)));
	}

	private TelegramBot bot;


	private void sendToTelegram(SendMessage message) throws TelegramApiException {

		bot.sendMessage(message);

	}
	
	class TelegramBot extends TelegramWebhookBot {

		private final DefaultBotOptions botOptions;

		public TelegramBot() {
			super();
			botOptions = ApiContext.getInstance(DefaultBotOptions.class);
		}

		public TelegramBot(DefaultBotOptions options) {
			super(options);
			this.botOptions = options;
		}

		@Override
		public String getBotUsername() {
			return telegramBotName;
		}

		@Override
		public String getBotToken() {
			return telegramBotToken;
		}

		@Override
		public String getBotPath() {
			return null;
		}

		@Override
		public BotApiMethod onWebhookUpdateReceived(Update update) {
			return null;
		}

	}
}
