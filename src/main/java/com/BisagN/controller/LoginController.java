package com.BisagN.controller;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.hibernate.SessionFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Controller;
/*import org.springframework.ui.ModelMap;*/
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.BisagN.FFL.models.TbHallOfFame;
import com.BisagN.FFL.models.TbInstituteDetail;
import com.BisagN.FFL.models.TbMiscActivity;
import com.BisagN.FFL.models.TbNewsLetter;
import com.BisagN.FFL.models.TbPictureGallary;
import com.BisagN.FFL.models.TbProfileDtl;
import com.BisagN.FFL.models.TbRegistrationDetail;
import com.BisagN.FFL.models.TbRegistrationDetailChild;
import com.BisagN.FFL.models.TbUserAlumniEjournal;
import com.BisagN.FFL.models.TbWhatsNewScroll;
import com.BisagN.FFL.models.Userloginchild;
import com.BisagN.FFL.repository.ActivityRepository;
import com.BisagN.FFL.repository.CountryRepository;
import com.BisagN.FFL.repository.HallOfFameRepository;
import com.BisagN.FFL.repository.InstituteRepository;
import com.BisagN.FFL.repository.PhotoGallaryRepository;
import com.BisagN.FFL.repository.ProfileRepository;
import com.BisagN.FFL.repository.RegistrationChildRepository;
import com.BisagN.FFL.repository.RegistrationRepository;
import com.BisagN.FFL.repository.UserEjournalRepository;
import com.BisagN.FFL.repository.UserLoginChildRepository;
import com.BisagN.FFL.repository.WhatsNewScrollRepository;
import com.BisagN.FFL.repository.newsLetterRepository;
import com.BisagN.Rbac.controller.ThoughtMasterController;
import com.BisagN.models.UserLogin;
import com.BisagN.repository.RoleRepository;

import com.BisagN.repository.ThoughtMasterRepository;
import com.BisagN.repository.UserLoginRepository;
import com.BisagN.service.UserDetailsServiceImpl;
import com.BisagN.util.Base64Service;

@Controller
public class LoginController {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	ThoughtMasterRepository ThoughtMasterRepositorynr;

	@Autowired
	HallOfFameRepository hallOfFameRepository;

	@Autowired
	UserLoginRepository userLoginRepository;

	@Autowired
	RegistrationRepository registrationRepository;

	@Autowired
	RegistrationChildRepository registrationChildRepository;

	@Autowired
	InstituteRepository instituteRepository;

	@Autowired
	PhotoGallaryRepository photoGallaryRepository;

	@Autowired
	ActivityRepository activityRepository;

	@Autowired
	newsLetterRepository NewsLetterRepository;

	@Autowired
	UserEjournalRepository userEjournalRepository;

	@Autowired
	WhatsNewScrollRepository whatsNewScrollRepository;

//	@Autowired
//	AlumniRepository alumniRepository;

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	UserLoginChildRepository userloginchildRepositroy;

	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired JdbcTemplate templet;

	public static final int MAX_FAILED_ATTEMPTS = 3;

	private static final long LOCK_TIME_DURATION = 10 * 60 * 1000;

	@Autowired
	private HitCounter hitCounter;

	@RequestMapping(value = "/admin/adminHome", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("adminHomePage");
		return model;
	}

//	@RequestMapping(value = "/admin/commonDashboard", method = RequestMethod.GET)
//	public ModelAndView AllDashboard(ModelMap Mmap, HttpSession session, HttpServletRequest request) {
//
//		return new ModelAndView("commanDashboardTiles");
//	}

	@RequestMapping(value = "/admin/Wizard", method = RequestMethod.GET)
	public ModelAndView Wizard(ModelMap Mmap, HttpSession session, HttpServletRequest request) {

		return new ModelAndView("Wizard");
	}

	@RequestMapping(value = "/admin/db_form", method = RequestMethod.GET)
	public ModelAndView db_form(ModelMap Mmap, HttpSession session, HttpServletRequest request) {

		return new ModelAndView("db_form");
	}

	@RequestMapping(value = "/admin/dashboard_page", method = RequestMethod.GET)
	public ModelAndView dashboard_page(ModelMap Mmap, HttpSession session, HttpServletRequest request) {

		return new ModelAndView("dashboard_page");
	}

	@GetMapping(value = "/FriendsForLife/")
	public String landingHome(Model model, @RequestParam(value = "msg", required = false) String msg,
			HttpServletRequest request) throws IOException {

		hitCounter.increment();
		int totalHits = hitCounter.getTotalHits();
		int hitsToday = hitCounter.getHitsToday();

		model.addAttribute("msg", msg);

		model.addAttribute("msg", msg);

		getLandingDisplayImages(request);

		return "landing";
	}

	@GetMapping(value = "/landing")
	public String landing(Model model, @RequestParam(value = "msg", required = false) String msg,
			HttpServletRequest request) throws IOException {
		model.addAttribute("msg", msg);
		request.getSession().setAttribute("Visitor_count", roleRepository.VisitorCounter());
		request.getSession().setAttribute("Institute_count", instituteRepository.InstituteCount());
		request.getSession().setAttribute("Embassy_count", userLoginRepository.EmbassyCount());
		request.getSession().setAttribute("Student_count", userLoginRepository.StudentCount());
		hitCounter.increment();
		int totalHits = hitCounter.getTotalHits();
		int hitsToday = hitCounter.getHitsToday();

		getLandingDisplayImages(request);

		return "landing";
	}

	@GetMapping(value = "/index")
	public String index(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "index";
	}

	@GetMapping(value = "/screen_reader")
	public String screen_reader(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "screen_reader";
	}

	@GetMapping(value = "/contactus")
	public String contactus(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "contactus";
	}

	@GetMapping(value = "/aim")
	public String aim(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "aim";
	}

	@GetMapping(value = "/function")
	public String function(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "function";
	}

	@GetMapping(value = "/objective")
	public String history(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "objective";
	}

	@GetMapping(value = "/reg_page")
	public String vision(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "reg_page";
	}

	@GetMapping(value = "/signin")
	public ModelAndView signin(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "msg", required = false) String msg,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		System.err.println("error " + error);
		System.err.println("msg " + msg);

		ModelAndView model = new ModelAndView();
		model.setViewName("signin");
        
		model.addObject("msg", msg);

		if (error != null) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION", error));
		}
		if (logout != null) {
			if (request.getHeader("Referer") != null) {
				model.addObject("msg", "You are logged out successfully.");
			}
		}

		return model;
	}

	@GetMapping(value = "/bog")
	public String organogram(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "bog";
	}

	@GetMapping(value = "/iaf_edu_wac")
	public String iaf_edu_wac(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "iaf_edu_wac";
	}

	@GetMapping(value = "/iaf_edu_swac")
	public String iaf_edu_swac(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "iaf_edu_swac";
	}

	@GetMapping(value = "/iaf_edu_eac")
	public String iaf_edu_eac(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "iaf_edu_eac";
	}

	@GetMapping(value = "/iaf_edu_cac")
	public String iaf_edu_cac(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "iaf_edu_cac";
	}

	@GetMapping(value = "/iaf_edu_sac")
	public String iaf_edu_sac(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "iaf_edu_sac";
	}

	@GetMapping(value = "/iaf_edu_mc")
	public String iaf_edu_mc(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "iaf_edu_mc";
	}

	@GetMapping(value = "/iaf_edu_tc")
	public String iaf_edu_tc(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "iaf_edu_tc";
	}

	@GetMapping(value = "/sitemap")
	public String sitemap(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "sitemap";
	}

	@GetMapping(value = "/calendar")
	public String calendar(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "calendar";
	}

	@RequestMapping(value = "/admin/demo_page", method = RequestMethod.GET)
	public ModelAndView demo_page(ModelMap Mmap, HttpSession session, HttpServletRequest request) {

		return new ModelAndView("demo_page");
	}

	@RequestMapping(value = "/commanDashboardStudent", method = RequestMethod.GET)
	public ModelAndView commanDashboardStudent(ModelMap Mmap, HttpSession session, HttpServletRequest request) {
		JSONParser jsonParser = new JSONParser();

		return new ModelAndView("commanDashboardStudent");

	}

	@RequestMapping(value = "/user/userDashboard")
	public ModelAndView userPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("userHomePage");
		return model;
	}

	@RequestMapping(value = "test")
	public ModelAndView test(@RequestParam String bd) {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "msg", required = false) String msg,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws IOException {

		int totalvisitor = roleRepository.VisitorCounter();
		request.getSession().setAttribute("Visitor_count", totalvisitor);
		request.getSession().setAttribute("Institute_count", instituteRepository.InstituteCount());
		request.getSession().setAttribute("Embassy_count", userLoginRepository.EmbassyCount());
		request.getSession().setAttribute("Student_count", userLoginRepository.StudentCount());
		ModelAndView model = new ModelAndView();
		hitCounter.increment();

		int totalHits = totalvisitor;
		int hitsToday = hitCounter.getHitsToday();

		if (error != null) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION", error));
		}
		if (logout != null) {
			if (request.getHeader("Referer") != null) {
				model.addObject("msg", "You are logged out successfully.");
			}
		}

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String Role = "";
		if (!authentication.getName().equals("anonymousUser")) {
			Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
			String role1 = "";
			for (String role : roles) {
				role1 = role;
			}
			Role = role1;
		}
		if (!Role.equals("")) {
			return new ModelAndView("redirect:/admin/commonDashboard");
		} else {
			String layout = "";
			List<String> msgLayout = roleRepository.getLayoutlist();
			layout += "<h3>";
			for (int m = 0; m < msgLayout.size(); m++) {
				if (m == 0) {
					layout += msgLayout.get(m);
				} else {
					layout += " | " + msgLayout.get(m);
				}
			}
			layout += "</h3>";
			model.addObject("layout", layout);
			model.addObject("server", getServerIP());

			model.setViewName("landing");
			getLandingDisplayImages(request);
		}
		return model;
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.POST)
	public ModelAndView logoutDo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
		SecurityContextHolder.clearContext();
		session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		for (Cookie cookie : request.getCookies()) {
			cookie.setMaxAge(0);
		}
		ModelAndView model = new ModelAndView();
		model.addObject("logout", "logout");
		model.setViewName("landing");

		getLandingDisplayImages(request);
		return model;
	}

	// customize the error message
//	public static String getErrorMessage(HttpServletRequest request, String key) {
//		Exception exception = (Exception) request.getSession().getAttribute(key);
//		String error = "";
//		if (exception instanceof BadCredentialsException) {
//			error = "Invalid username or password!";
//		} else if (exception instanceof LockedException) {
//			error = exception.getMessage();
//		} else if (exception instanceof SessionAuthenticationException) {
//			exception.printStackTrace();
//			error = "User Already logged in";// exception.getMessage();
//		} else if (exception instanceof DisabledException) {
//			error = "User is disabled";
//		}
////		else {
////			error = "Invalid username or password!";
////		}
//		return error;
//	}
	public static String getErrorMessage(HttpServletRequest request, String key, String customerror) {
		Exception exception = (Exception) request.getSession().getAttribute(key);
		System.out.println(exception);
		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username or password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else if (exception instanceof SessionAuthenticationException) {
			exception.printStackTrace();
			error = "User Already logged in";// exception.getMessage();
		} else if (exception instanceof DisabledException) {
			error = "User is disabled";
		} else {
			error = customerror;
		}
		return error;
	}

	@RequestMapping(value = "/user/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addObject("username", userDetail.getUsername());
		}
		model.setViewName("403");
		return model;
	}

	@RequestMapping(value = "/genCapchaCode")
	public @ResponseBody byte[] genCapchaCode1(HttpServletRequest request) {
		byte[] image = createImage(request);
		if (!image.toString().equals("")) {
			return image;
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/checkCapchaCode", method = RequestMethod.POST)
	public @ResponseBody boolean checkCapchaCode(HttpServletRequest request, String iCapcha) {
		String txtInput = iCapcha.replaceAll("\\s", "").toString();
		
		
		String capcha = request.getSession().getAttribute("capcha").toString();
		if (txtInput.equals(capcha)) {
			request.getSession().setAttribute("captchaValidate", "true");
			return true;
		} else {
			request.getSession().setAttribute("captchaValidate", "false");

			return false;
		}
	}

	String captchaString = "";

	private byte[] createImage(HttpServletRequest request) {
		try {
			Color backgroundColor = Color.white;
			Color borderColor = Color.black;
			Color textColor = Color.black;
			Color circleColor = new Color(190, 160, 150);
			Font textFont = new Font("Verdana", Font.ITALIC, 30);
			int charsToPrint = 5;
			int width = 120;
			int height = 50;
			int circlesToDraw = 30;
			float horizMargin = 10.0f;
			double rotationRange = 1.5;
			BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
			g.setColor(backgroundColor);
			g.fillRect(0, 0, width, height);

			// lets make some noisey circles
			g.setColor(circleColor);
			for (int i = 0; i < circlesToDraw; i++) {
				int L = (int) (Math.random() * height / 2.0);
				int X = (int) (Math.random() * width - L);
				int Y = (int) (Math.random() * height - L);
				g.draw3DRect(X, Y, L * 2, L * 2, true);
			}

			// Add horizontal lines
			g.setColor(Color.BLACK);
			int numHorizontalLines = 2;
			for (int i = 0; i < numHorizontalLines; i++) {
				int y = (int) (Math.random() * height);
				g.drawLine(0, y, width, y);
			}

			// Add vertical lines
			int numVerticalLines = 2;
			for (int i = 0; i < numVerticalLines; i++) {
				int x = (int) (Math.random() * width);
				g.drawLine(x, 0, x, height);
			}

			g.setColor(textColor);
			g.setFont(textFont);
			FontMetrics fontMetrics = g.getFontMetrics();
			int maxAdvance = fontMetrics.getMaxAdvance();
			int fontHeight = fontMetrics.getHeight();

			// i removed 1 and l and i because there are confusing to users...
			// Z, z, and N also get confusing when rotated
			// this should ideally be done for every language...
			// 0, O and o removed because there are confusing to users...
			// i like controlling the characters though because it helps prevent confusion
			
			// String elegibleChars = "ABCDEFGHJKLMNPQRSTUVWXYabcdefghjkmnpqrstuvwxy23456789";
			String elegibleChars = "AAAAA";
			char[] chars = elegibleChars.toCharArray();
			float spaceForLetters = -horizMargin * 5 + width;
			float spacePerChar = 19; // spaceForLetters / (charsToPrint - 0.0f);

			StringBuffer finalString = new StringBuffer();
			for (int i = 0; i < charsToPrint; i++) {
				double randomValue = Math.random();
				int randomIndex = (int) Math.round(randomValue * (chars.length - 1));
				char characterToShow = chars[randomIndex];
				finalString.append(characterToShow);

				// this is a separate canvas used for the character so that
				// we can rotate it independently
				int charWidth = fontMetrics.charWidth(characterToShow);
				int charDim = Math.max(maxAdvance, fontHeight);
				int halfCharDim = (int) (charDim / 2);
				BufferedImage charImage = new BufferedImage(charDim, charDim, BufferedImage.TYPE_INT_ARGB);
				Graphics2D charGraphics = charImage.createGraphics();
				charGraphics.translate(halfCharDim, halfCharDim);
				double angle = (Math.random() - 0.5) * rotationRange;
				charGraphics.transform(AffineTransform.getRotateInstance(angle));
				charGraphics.translate(-halfCharDim, -halfCharDim);
				charGraphics.setColor(textColor);
				charGraphics.setFont(textFont);
				int charX = (int) (0.5 * charDim - 0.5 * charWidth);
				charGraphics.drawString(" " + characterToShow, charX,
						(int) ((charDim - fontMetrics.getAscent()) / 2 + fontMetrics.getAscent()));
				float x = horizMargin + spacePerChar * (i) - charDim / 2.0f;
				int y = (int) ((height - charDim) / 2);
				g.drawImage(charImage, (int) x, y, charDim, charDim, null, null);
				charGraphics.dispose();
			}
			g.setColor(borderColor);
			g.drawRect(0, 0, width - 1, height - 1);
			g.dispose();
			captchaString = finalString.toString();

			// return bufferedImage;
			ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
			try {
				ImageIO.write(bufferedImage, "jpg", baos1);
				baos1.flush();
				baos1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			byte[] imageInByteArray = baos1.toByteArray();
			HttpSession session = request.getSession();
			System.out.println("captchaString : " + captchaString);
			session.setAttribute("capcha", captchaString);
			return imageInByteArray;
		} catch (Exception ioe) {
			byte[] imageInByteArray = null;
			return imageInByteArray;
		}
	}

//	private byte[] createImage(HttpServletRequest request) {
//		try {
//			Color backgroundColor = Color.white;
//			Color borderColor = Color.black;
//			Color textColor = Color.black;
//			Color circleColor = new Color(190, 160, 150);
//			Font textFont = new Font("Verdana", Font.BOLD, 30);
//			int charsToPrint = 5;
//			int width = 150;
//			int height = 50;
//			int circlesToDraw = 25;
//			float horizMargin = 10.0f;
//			double rotationRange = 0.7;
//			BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//			Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
//			g.setColor(backgroundColor);
//			g.fillRect(0, 0, width, height);
//
//			// lets make some noisey circles
//			g.setColor(circleColor);
//			for (int i = 0; i < circlesToDraw; i++) {
//				int L = (int) (Math.random() * height / 2.0);
//				int X = (int) (Math.random() * width - L);
//				int Y = (int) (Math.random() * height - L);
//				g.draw3DRect(X, Y, L * 2, L * 2, true);
//			}
//			g.setColor(textColor);
//			g.setFont(textFont);
//			FontMetrics fontMetrics = g.getFontMetrics();
//			int maxAdvance = fontMetrics.getMaxAdvance();
//			int fontHeight = fontMetrics.getHeight();
//
//			// i removed 1 and l and i because there are confusing to users...
//			// Z, z, and N also get confusing when rotated
//			// this should ideally be done for every language...
//			// 0, O and o removed because there are confusing to users...
//			// i like controlling the characters though because it helps prevent confusion
//			String elegibleChars = "ABCDEFGHJKLMNPQRSTUVWXYabcdefghjkmnpqrstuvwxy23456789";
//			char[] chars = elegibleChars.toCharArray();
//			float spaceForLetters = -horizMargin * 3 + width;
//			float spacePerChar = spaceForLetters / (charsToPrint - 1.0f);
//			StringBuffer finalString = new StringBuffer();
//			for (int i = 0; i < charsToPrint; i++) {
//				double randomValue = Math.random();
//				int randomIndex = (int) Math.round(randomValue * (chars.length - 1));
//				char characterToShow = chars[randomIndex];
//				finalString.append(characterToShow);
//
//				// this is a separate canvas used for the character so that
//				// we can rotate it independently
//				int charWidth = fontMetrics.charWidth(characterToShow);
//				int charDim = Math.max(maxAdvance, fontHeight);
//				int halfCharDim = (int) (charDim / 2);
//				BufferedImage charImage = new BufferedImage(charDim, charDim, BufferedImage.TYPE_INT_ARGB);
//				Graphics2D charGraphics = charImage.createGraphics();
//				charGraphics.translate(halfCharDim, halfCharDim);
//				double angle = (Math.random() - 0.5) * rotationRange;
//				charGraphics.transform(AffineTransform.getRotateInstance(angle));
//				charGraphics.translate(-halfCharDim, -halfCharDim);
//				charGraphics.setColor(textColor);
//				charGraphics.setFont(textFont);
//				int charX = (int) (0.5 * charDim - 0.5 * charWidth);
//				charGraphics.drawString("" + characterToShow, charX,
//						(int) ((charDim - fontMetrics.getAscent()) / 2 + fontMetrics.getAscent()));
//				float x = horizMargin + spacePerChar * (i) - charDim / 2.0f;
//				int y = (int) ((height - charDim) / 2);
//				g.drawImage(charImage, (int) x, y, charDim, charDim, null, null);
//				charGraphics.dispose();
//			}
//			g.setColor(borderColor);
//			g.drawRect(0, 0, width - 1, height - 1);
//			g.dispose();
//			captchaString = finalString.toString();
//
//			// return bufferedImage;
//			ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
//			try {
//				ImageIO.write(bufferedImage, "jpg", baos1);
//				baos1.flush();
//				baos1.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			byte[] imageInByteArray = baos1.toByteArray();
//			HttpSession session = request.getSession();
//			session.setAttribute("capcha", captchaString);
//			return imageInByteArray;
//		} catch (Exception ioe) {
//			byte[] imageInByteArray = null;
//			return imageInByteArray;
//		}
//	}

	public String getServerIP() {
		try (final DatagramSocket s = new DatagramSocket()) {
			try {
				s.connect(InetAddress.getByName("8.8.8.8"), 10002);
				String hadd = s.getLocalAddress().getHostAddress();
				if (hadd.equals("152.1.13.51")) {
					return "Server 1";
				} else if (hadd.equals("152.1.13.52")) {
					return "Server 2";
				} else if (hadd.equals("152.1.13.53")) {
					return "Server 3";
				} else {
					return "Unknown Server";
				}
			} catch (UnknownHostException e) {
				return "Unknown Server";
			}
		} catch (SocketException e1) {
			return "Unknown Server";
		}
	}

	@GetMapping(value = "/gallery")
	public String gallery(Model model, @RequestParam(value = "msg", required = false) String msg,
			HttpServletRequest request, @RequestParam(value = "CategoryName", required = false) String CategoryName)
			throws NumberFormatException, IOException {
		model.addAttribute("msg", msg);
		request.getSession().setAttribute("CategoryName", CategoryName);

		if (CategoryName != null) {
			String Cat = AESGCM.decrypt(new String(Base64Service.decode(CategoryName.toString())));
			if (Cat.equalsIgnoreCase("Society")) {
				request.getSession().setAttribute("CatType", "Society");
			} else {
				request.getSession().setAttribute("CatType", "School");
			}
		}
		return "gallery";

	}

	@GetMapping(value = "/iaf_edu_airhq")
	public String iaf_edu_airhq(HttpServletRequest request, Model model,
			@RequestParam(value = "msg", required = false) String msg,
			@RequestParam(value = "id", required = false) String id) throws IOException {
		model.addAttribute("msg", msg);
		model.addAttribute("id", id);

		String id1;
		if (id == null) {
			id1 = "PRIMARY";
		} else {
			id1 = AESGCM.decrypt(new String(Base64Service.decode(id.toString())));
		}
		model.addAttribute("id1", id1);

		String clrs = "";
		String schoolHtml = "";
		String primaryHtml = "";
		String preprimaryHtml = "";
		String srsecHtml = "";
		String secHtml = "";
		String middleHtml = "";

		request.getSession().setAttribute("SchoolDetails", schoolHtml);
		request.getSession().setAttribute("primaryHtml", primaryHtml);
		request.getSession().setAttribute("preprimaryHtml", preprimaryHtml);
		request.getSession().setAttribute("srsecHtml", srsecHtml);
		request.getSession().setAttribute("middleHtml", middleHtml);
		request.getSession().setAttribute("secHtml", secHtml);

		return "iaf_edu_airhq";
	}

	@GetMapping(value = "/video_gallery")
	public String video_gallery(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "video_gallery";
	}

	public String imageEncoderDecoder(String imagepath) throws IOException {
		String imageString = "";
		// image path declaration
		// String imgPath = "src/main/resources/images/bean.png";

		// read image from file
		try {
			FileInputStream stream = new FileInputStream(imagepath);

			// get byte array from image stream
			int bufLength = 2048;
			byte[] buffer = new byte[2048];
			byte[] data;

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int readLength;
			while ((readLength = stream.read(buffer, 0, bufLength)) != -1) {
				out.write(buffer, 0, readLength);
			}

			data = out.toByteArray();
			imageString = Base64.getEncoder().withoutPadding().encodeToString(data);

			out.close();
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imageString;
	}

	// =========================================New Update
	// 300623=================================//

	private void getLandingDisplayImages(HttpServletRequest request) throws IOException {
		String thought = ThoughtMasterController.thought;
		if (thought.equalsIgnoreCase("")) {
			thought = ThoughtMasterRepositorynr.findRandamthoughts();
			ThoughtMasterController.thought = thought;
		}
		if (!(request.getSession().getAttribute("ulString") != null
				&& request.getSession().getAttribute("photoesString") != null)) {

			String ulString = "<li><a class=\"is_active\" href=\"#!\" data-filter=\"*\">Show All</a></li>";
			ulString += "<li><a href=\"#!\" data-filter=\".AirForceHqRo\">Air Hq</a></li>";

			String img = "";
			String imgTitle = "";
			String imagestr = "";
			String temp = "";
			String photoesString = "";

			temp = "\'data:image/jpeg;base64," + imagestr + "\'";
			String Category = Base64Service.encode(AESGCM.encrypt(String.valueOf("Society")).getBytes());

			photoesString += "<div\r\n"
					+ "	class=\"col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer "
					+ "IAF E & C Society" + "\">\r\n" + "		<div class=\"events_item\">\r\n"
					+ "			<div class=\"thumb\">\r\n" + "				<a href=\"gallery?CategoryName=" + Category
					+ "\"><img  class=\"card-image\" \r\n" + "					src=" + temp + "  alt=\"\" title=\""
					+ imgTitle + "\"></a>\r\n" + "<span class=\"price\"><h6>\r\n" + "					"
					+ "IAF E & C Society" + "</h6></span>\r\n" + "			</div>\r\n" + "			<div >\r\n"
					+ "			</div>\r\n" + "		</div>\r\n" + "	</div>";

			// School Category Wise

			String[] SchoolCategoriesArray = { "PRE-PRIMARY", "PRIMARY", "MIDDLE", "SECONDARY", "SR SECONDARY" };
			for (int i = 0; i < 5; i++) {
				String CurrentSchoolCategory = SchoolCategoriesArray[4 - i];

			}

			request.getSession().setAttribute("thought", thought);
			request.getSession().setAttribute("ulString", ulString);
			request.getSession().setAttribute("photoesString", photoesString);

		}
	}

	@GetMapping(value = "/screen_reader_access")
	public String screen_reader_access(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "screen_reader_access";
	}

	@GetMapping(value = "/terms_conditions")
	public String terms_conditions(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "terms_conditions";
	}

	@GetMapping(value = "/help")
	public String help(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "help";
	}

	@GetMapping(value = "/websitepolicy")
	public String websitepolicy(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "websitepolicy";
	}

	/*
	 * @GetMapping(value = "/CATA") public String CATA(Model
	 * model, @RequestParam(value = "msg", required = false) String msg) {
	 * model.addAttribute("msg", msg); return "CATA"; }
	 * 
	 * @GetMapping(value = "/photogallery") public String photogallery(Model
	 * model, @RequestParam(value = "msg", required = false) String msg) {
	 * model.addAttribute("msg", msg); return "photogallery"; }
	 */
	
	@GetMapping(value = "/photogallery")
    public ModelAndView getPhotogallery(Model model) {
        List<Map<String,Object>> getPhotos = templet.queryForList("select * from tb_admin_setting where flag='gallery'");
        model.addAttribute("getPhotos", getPhotos);
        return new ModelAndView("photogallery");
    }
@GetMapping(value = "/CATA")
    public ModelAndView getInstitueeee(Model model) {
        List<Map<String,Object>> institute = templet.queryForList("select imageurl,text from tb_admin_setting where flag='institute'");
        model.addAttribute("institute", institute);
        return new ModelAndView("CATA");
    }

	
	
	@RequestMapping(value = "/admin/CAT_dashboard", method = RequestMethod.GET)
	public ModelAndView CAT_dashboard(ModelMap Mmap, HttpSession session, HttpServletRequest request) {

		String username = request.getSession().getAttribute("username").toString();
		Mmap.put("username", username);
		return new ModelAndView("CAT_dashboard");
	}
//	@RequestMapping(value = "/admin/E_Journals_MCTE", method = RequestMethod.GET)
//	public ModelAndView E_Journals_MCTE(ModelMap Mmap, HttpSession session, HttpServletRequest request) {
//		return new ModelAndView("E_Journals_MCTE");
//	}
//	@GetMapping(value = "/signup")
//	public String signup(Model model, @RequestParam(value = "msg", required = false) String msg) {
//		model.addAttribute("msg", msg);
//		return "signup";
//	}

	@RequestMapping(value = "/admin/commonDashboard", method = RequestMethod.GET)
	public ModelAndView commonDashboard(ModelMap Mmap, HttpSession session, HttpServletRequest request) {
		System.out.println(request.getSession().getAttribute("role"));
		String roleName = request.getSession().getAttribute("role").toString();

		if (roleName.equalsIgnoreCase("ADMIN")) {
			String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
			String sessionusername = request.getSession().getAttribute("username").toString();
			Integer userid = Integer.parseInt(sessionuserid);
			Integer instituteid = userLoginRepository.instituteid1(userid);
			Optional<UserLogin> userLogin = userLoginRepository.findById(Integer.parseInt(sessionuserid));
			Integer aluminiinstituteid = instituteRepository.instituteid(sessionusername);

			int HallofFameCount = hallOfFameRepository.LoadHallOffameshowData1(userid);
			int AlumniCount = registrationRepository.LoadAlumniDashboard1(instituteid);
			int photogallaryCount = photoGallaryRepository.LoadphotogallaryshowData1(userid);
			int ActivityCount = activityRepository.LoadActivityDashboard1(userid);
			int NewsLettersCount = NewsLetterRepository.LoadNewsLettersDashboard1(userid);
			int Ejournalcount = userEjournalRepository.LoadJournalDashboard1(userLogin.get().getInstituteId());

			Mmap.put("HallofFameCount", HallofFameCount);
			Mmap.put("AlumniCount", AlumniCount);
			Mmap.put("photogallaryCount", photogallaryCount);
			Mmap.put("ActivityCount", ActivityCount);
			Mmap.put("NewsLettersCount", NewsLettersCount);
			Mmap.put("Ejournalcount", Ejournalcount);
			Mmap.put("bradcrumbs", sessionusername);
			Mmap.put("role", roleName);

			Mmap.put("dashboadURL", "instituteDashboard");

			return new ModelAndView("MCTE_dashboard");
		} else if (roleName.equalsIgnoreCase("USER")) {

			Mmap.put("role", roleName);

			Mmap.put("dashboadURL", "commonDashboard");
			return new ModelAndView("MCTE_dashboard");

		} else {
			return new ModelAndView("commanDashboardTiles");
		}
	}

	@ResponseBody
	@RequestMapping(value = "/admin/getuserdashboarddtl", method = RequestMethod.POST, produces = {
			"application/json" })
	public String getuserdashboarddtl(@RequestBody String data, HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";

		try {

			jsonObject = (JSONObject) jsonp.parse(data);

			int instituteid = Integer.parseInt(jsonObject.get("institute").toString());
			Optional<TbInstituteDetail> tbInstituteDetail = instituteRepository.findById(instituteid);

//			String shortInstituteName = tbInstituteDetail.get().getInstituteName().substring(
//					tbInstituteDetail.get().getInstituteName().indexOf('(') + 1,
//					tbInstituteDetail.get().getInstituteName().indexOf(')'));

			UserLogin userLogin = userLoginRepository.findUserinstituteFromInsID(instituteid);
			request.getSession().setAttribute("instituteuserid", userLogin.getUserId());

			String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();

			Userloginchild userloginchild = userloginchildRepositroy
					.findByuserinstitueid(Integer.parseInt(sessionuserid), instituteid);
			if (userloginchild != null) {

				int HallofFameCount = hallOfFameRepository.LoadHallOffameshowData1(userLogin.getUserId());
				int photogallaryCount = photoGallaryRepository.LoadphotogallaryshowData1(userLogin.getUserId());
				int ActivityCount = activityRepository.LoadActivityDashboard1(userLogin.getUserId());
				int NewsLettersCount = NewsLetterRepository.LoadNewsLettersDashboard1(userLogin.getUserId());
				int Ejournalcount = userEjournalRepository.LoadJournalDashboard1(userLogin.getInstituteId());

				jsonobjectout.put("HallofFameCount", HallofFameCount);
				jsonobjectout.put("photogallaryCount", photogallaryCount);
				jsonobjectout.put("ActivityCount", ActivityCount);
				jsonobjectout.put("NewsLettersCount", NewsLettersCount);
				jsonobjectout.put("Ejournalcount", Ejournalcount);

				jsonobjectout.put("status", "1");
				returnstring = jsonobjectout.toJSONString();
			} else {
				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "Unauthorized Access");
				returnstring = jsonobjectout.toJSONString();
			}

		} catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", "Failure");
			returnstring = jsonobjectout.toJSONString();
		}

		return returnstring;
	}

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/admin/dashnameData", method = RequestMethod.POST, produces = { "application/json" })
	public String dashnameData(@RequestParam(value = "dashname", required = false) String dashname,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONArray jSONArray = new JSONArray();
		JSONObject object = new JSONObject();
		JSONObject object1 = new JSONObject();

		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		String username = request.getSession().getAttribute("username").toString();
		String roleName = request.getSession().getAttribute("role").toString();
		request.getSession().setAttribute("dashname", dashname);

		return dashname;
	}

	@RequestMapping(value = "/admin/E_Journals", method = RequestMethod.GET)
	public ModelAndView E_Journals(ModelMap Mmap, HttpSession session, HttpServletRequest request) {
		String sessionusername = request.getSession().getAttribute("username").toString();
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		String roleName = request.getSession().getAttribute("role").toString();
		Optional<UserLogin> userLogin = userLoginRepository.findById(Integer.parseInt(sessionuserid));
		if (roleName.equalsIgnoreCase("USER")) {
			String instituteuserid = request.getSession().getAttribute("instituteuserid").toString();
			Optional<UserLogin> userlogin = userLoginRepository.findById(Integer.parseInt(instituteuserid));

			sessionusername = userlogin.get().getUserName();
		}

		long totalpages = getTotalNumberOfPages(userLogin.get().getInstituteId(), request, "eJournal", sessionusername);

		Mmap.put("dashname", sessionusername);
		Mmap.put("totalpages", totalpages);
		return new ModelAndView("E_Journals_MCTE");
	}

	@GetMapping(value = "/signup")
	public String signup(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("msg", msg);
		return "signup";
	}

	@RequestMapping(value = "/admin/E_Journal_dtlPage", method = RequestMethod.GET)
	public ModelAndView E_Journal_dtlPage(ModelMap Mmap, HttpSession session, HttpServletRequest request) {
		String sessionusername = request.getSession().getAttribute("username").toString();
		Mmap.put("dashname", sessionusername);
		return new ModelAndView("E_Journal_dtlPage");
	}

	@RequestMapping(value = "/admin/FFL_newsletter", method = RequestMethod.GET)
	public ModelAndView FFL_newsletter(ModelMap Mmap, HttpSession session, HttpServletRequest request)
			throws ParseException {
		String sessionusername = request.getSession().getAttribute("username").toString();
		String roleName = request.getSession().getAttribute("role").toString();
		if (roleName.equalsIgnoreCase("USER")) {
			String instituteuserid = request.getSession().getAttribute("instituteuserid").toString();
			Optional<UserLogin> userlogin = userLoginRepository.findById(Integer.parseInt(instituteuserid));

			sessionusername = userlogin.get().getUserName();
		}
		String ffl_newsletter = getFFlnewsletter(sessionusername, request);
		Mmap.put("dashname", sessionusername);
		Mmap.addAttribute("ffl_newsletter", ffl_newsletter);
		return new ModelAndView("FFL_newsletter");
	}

	@RequestMapping(value = "/admin/HallOfFame", method = RequestMethod.GET)
	public ModelAndView HallOfFame(ModelMap Mmap, HttpSession session, HttpServletRequest request) {
		String sessionusername = request.getSession().getAttribute("username").toString();
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();

		String roleName = request.getSession().getAttribute("role").toString();
		if (roleName.equalsIgnoreCase("USER")) {
			String instituteuserid = request.getSession().getAttribute("instituteuserid").toString();
			Optional<UserLogin> userlogin = userLoginRepository.findById(Integer.parseInt(instituteuserid));

			sessionusername = userlogin.get().getUserName();
		}

		long totalpages = getTotalNumberOfPages(Integer.parseInt(sessionuserid), request, "HoF", sessionusername);
		Mmap.put("dashname", sessionusername);
		Mmap.put("totalpages", totalpages);
		return new ModelAndView("HallOfFame");
	}

	@RequestMapping(value = "/admin/FFC_Alumni", method = RequestMethod.GET)
	public ModelAndView FFC_Alumni(ModelMap Mmap, HttpSession session, HttpServletRequest request) {
		String sessionusername = request.getSession().getAttribute("username").toString();
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		long totalpages = getTotalNumberOfPages(Integer.parseInt(sessionuserid), request, "ALUMNI", sessionusername);

		Mmap.put("dashname", sessionusername);
		Mmap.put("totalpages", totalpages);
		return new ModelAndView("FFC_Alumni");
	}

	@RequestMapping(value = "/admin/Picture_gallery", method = RequestMethod.GET)
	public ModelAndView Picture_gallery(ModelMap Mmap, HttpSession session, HttpServletRequest request) {
		String sessionusername = request.getSession().getAttribute("username").toString();
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		String roleName = request.getSession().getAttribute("role").toString();
		if (roleName.equalsIgnoreCase("USER")) {
			String instituteuserid = request.getSession().getAttribute("instituteuserid").toString();
			Optional<UserLogin> userlogin = userLoginRepository.findById(Integer.parseInt(instituteuserid));

			sessionusername = userlogin.get().getUserName();
		}
		long totalpages = getTotalNumberOfPages(Integer.parseInt(sessionuserid), request, "PictureGallery",
				sessionusername);
		Mmap.put("dashname", sessionusername);
		Mmap.put("totalpages", totalpages);
		return new ModelAndView("Picture_gallery");
	}

	@RequestMapping(value = "/admin/all_news", method = RequestMethod.GET)
	public ModelAndView all_news(ModelMap Mmap, HttpSession session, HttpServletRequest request) throws ParseException {

		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		String sessionusername = request.getSession().getAttribute("username").toString();
		String roleName = request.getSession().getAttribute("role").toString();
		if (roleName.equalsIgnoreCase("USER")) {
			String instituteuserid = request.getSession().getAttribute("instituteuserid").toString();
			Optional<UserLogin> userlogin = userLoginRepository.findById(Integer.parseInt(instituteuserid));

			sessionusername = userlogin.get().getUserName();
		}
		long totalpages = getTotalNumberOfPages(Integer.parseInt(sessionuserid), request, "ALLNEWS", sessionusername);
//		String list = getLetters(dashname);
		Mmap.put("dashname", sessionusername);
		Mmap.put("totalpages", totalpages);
//		Mmap.addAttribute("list", list);
		return new ModelAndView("all_news");
	}

	@RequestMapping(value = "/admin/MISC_activities", method = RequestMethod.GET)
	public ModelAndView MISC_activities(ModelMap Mmap, HttpSession session, HttpServletRequest request) {
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		String sessionusername = request.getSession().getAttribute("username").toString();
		String roleName = request.getSession().getAttribute("role").toString();
		if (roleName.equalsIgnoreCase("USER")) {
			String instituteuserid = request.getSession().getAttribute("instituteuserid").toString();
			Optional<UserLogin> userlogin = userLoginRepository.findById(Integer.parseInt(instituteuserid));

			sessionusername = userlogin.get().getUserName();
		}
		long totalpages = getTotalNumberOfPages(Integer.parseInt(sessionuserid), request, "MISC_ACTIVITY",
				sessionusername);

		Mmap.put("dashname", sessionusername);
		Mmap.put("totalpages", totalpages);

		return new ModelAndView("MISC_activities");
	}

	public long getTotalNumberOfPages(int userId, HttpServletRequest request, String type, String dashname) {

		long totalRecords = 0;
		int startPage = 1;
		int pageLength = 0;
		if (type.equalsIgnoreCase("HOF")) {
			pageLength = 9;
		} else if (type.equalsIgnoreCase("ALUMNI")) {
			pageLength = 9;
		} else if (type.equalsIgnoreCase("PictureGallery")) {
			pageLength = 6;
		} else if (type.equalsIgnoreCase("MISC_ACTIVITY")) {
			pageLength = 3;
		} else if (type.equalsIgnoreCase("eJournal")) {

			pageLength = 4;
		} else if (type.equalsIgnoreCase("ALLNEWS")) {

			pageLength = 10;
		}
		totalRecords = (long) LoadPageData(startPage, pageLength, userId, request, type, dashname);

		// Calculate the total number of pages
		return totalRecords;
	}

	public long LoadPageData(int startPage, int pageLength, int userId, HttpServletRequest request, String type,
			String dashname) {

		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		String sessionusername = request.getSession().getAttribute("username").toString();
		Integer userid = Integer.parseInt(sessionuserid);
		String roleName = request.getSession().getAttribute("role").toString();
		if (roleName.equalsIgnoreCase("USER")) {
			String instituteuserid = request.getSession().getAttribute("instituteuserid").toString();
			Optional<UserLogin> userlogin = userLoginRepository.findById(Integer.parseInt(instituteuserid));

			sessionusername = userlogin.get().getUserName();
			userid = Integer.parseInt(instituteuserid);
		}

		Integer aluminiinstituteid = instituteRepository.instituteid(sessionusername);
		Integer instituteid = userLoginRepository.instituteid1(userid);

		int total = 0;
		if (type.equalsIgnoreCase("HOF")) {
			total = hallOfFameRepository.LoadHallOffameshowData1(userid);
		} else if (type.equalsIgnoreCase("ALUMNI")) {
			total = registrationRepository.LoadAlumniDashboard1(instituteid);
		} else if (type.equalsIgnoreCase("PictureGallery")) {
			total = photoGallaryRepository.LoadphotogallaryshowData1(userid);
		} else if (type.equalsIgnoreCase("MISC_ACTIVITY")) {
			total = activityRepository.LoadActivityDashboard1(userid);
		} else if (type.equalsIgnoreCase("eJournal")) {

			total = userEjournalRepository.LoadJournalDashboard1(userid);

		} else if (type.equalsIgnoreCase("ALLNEWS")) {

			total = NewsLetterRepository.LoadNewsLettersDashboard1(userid);

		}
		long lastPage = (total / pageLength);

		if (total % pageLength != 0) {
			lastPage = Math.max(1, lastPage + 1);
		} else {
			lastPage = Math.max(1, lastPage);
		}

		return lastPage;

	}

	@ResponseBody
	@RequestMapping(value = "/admin/getallnews", method = RequestMethod.POST, produces = { "application/json" })
	public String getallnews(@RequestBody String data, HttpServletRequest request) throws ParseException {
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		String roleName = request.getSession().getAttribute("role").toString();
		int recordsPerPage = 10;

		try {
			jsonObject = (JSONObject) jsonp.parse(data);

			String currentPage = jsonObject.get("currentPage").toString();

			int offset = (Integer.parseInt(currentPage) - 1) * recordsPerPage;
			Integer userid = Integer.parseInt(sessionuserid);
			if (roleName.equalsIgnoreCase("USER")) {
				String instituteuserid = request.getSession().getAttribute("instituteuserid").toString();
				Optional<UserLogin> userlogin = userLoginRepository.findById(Integer.parseInt(instituteuserid));

				userid = Integer.parseInt(instituteuserid);
			}
			List<TbNewsLetter> list = NewsLetterRepository.getAllData(offset, recordsPerPage, userid);

			String values = "";
			int formcounter = 1;
			if (list.size() != 0) {
				values = "<ul class='updates-data all-data'>";
				for (TbNewsLetter tb_detail : list) {
					String filePath = tb_detail.getUploadPdf();

					// Get the size of the PDF file
					long fileSize = new File(filePath).length();
					String unit;
					double fileSizeToShow;
					if (fileSize < 1024) {
						fileSizeToShow = fileSize;
						unit = "B";
					} else if (fileSize < 1024 * 1024) {
						fileSizeToShow = (double) fileSize / 1024;
						unit = "KB";
					} else if (fileSize < 1024 * 1024 * 1024) {
						fileSizeToShow = (double) fileSize / (1024 * 1024);
						unit = "MB";
					} else {
						fileSizeToShow = (double) fileSize / (1024 * 1024 * 1024);
						unit = "GB";
					}

					String hidden = "<input type='hidden' name='hid" + formcounter + "' id='hid" + formcounter
							+ "' value='"
							+ Base64Service.encode(AESGCM.encrypt(String.valueOf(tb_detail.getId())).getBytes())
							+ "' /> ";

					values += "<li class=\"update-wrapper\">\r\n" + "  <div class=\"date-with-list\">\r\n"
							+ "    <div class=\"info-date\">\r\n" + "      <span class=\"info-main\">"
							+ getDate(tb_detail.getCreatedDate()) + "</span> <span class=\"info-sub\">"
							+ getmonthyear(tb_detail.getCreatedDate()) + "</span>\r\n" + "    </div>\r\n"
							+ "    <div class=\"info-content\">\r\n" + "      <a href=\"#\" class=\"openpdf\">" + hidden
							+ tb_detail.getDescription() + "</a>\r\n" + "    </div>\r\n"
							+ "    <div class=\"pdf-btn\">\r\n"
							+ "      <a href=\"#\"  class='view-pdf-btn' title=\"Click Here to View PDF file that opens in new window\"><i class=\"fas fa-file-pdf openpdf1\"></i>"
							+ hidden + "</a> <span class=\"pdf-size\">(" + String.format("%.2f", fileSizeToShow) + " "
							+ unit + ")</span>\r\n" + "    </div>\r\n" + "  </div>\r\n" + "</li>";

					formcounter++;

				}
				values += "</ul>";

			}
			int NewsLettersCount = NewsLetterRepository.LoadNewsLettersDashboard1(userid);
			jsonobjectout.put("NewsLettersCount", NewsLettersCount);
			jsonobjectout.put("notdata", values);
			jsonobjectout.put("status", "1");
			jsonobjectout.put("message", "News Letters Successfully");
			returnstring = jsonobjectout.toJSONString();

		} catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", "Failure");
			returnstring = jsonobjectout.toJSONString();
		}

		return returnstring;
	}

	public String getFFlnewsletter(String dashname, HttpServletRequest request) throws ParseException {
		Integer instituteid = userLoginRepository.instituteid(dashname);
		String roleName = request.getSession().getAttribute("role").toString();
		if (roleName.equalsIgnoreCase("USER")) {
			String instituteuserid = request.getSession().getAttribute("instituteuserid").toString();
			Optional<UserLogin> userlogin = userLoginRepository.findById(Integer.parseInt(instituteuserid));

			instituteid = Integer.parseInt(instituteuserid);
		}
		List<TbNewsLetter> list = NewsLetterRepository.getAllData1(instituteid);
		String values = "";
		int formcounter = 1;

		for (int i = 0; i < list.size(); i++) {
			TbNewsLetter tb_detail = list.get(i);

			String hidden = "<input type='hidden' name='hid" + formcounter + "' id='hid" + formcounter + "' value='"
					+ Base64Service.encode(AESGCM.encrypt(String.valueOf(tb_detail.getId())).getBytes()) + "' /> ";

			values += "<li class=\"update-wrapper\">\r\n"
					+ "													<div class=\"date-with-list\">\r\n"
					+ "														<div class=\"info-date\">\r\n"
					+ "															<span class=\"info-main\">"
					+ getDate(tb_detail.getCreatedDate()) + "</span> <span class=\"info-sub\">"
					+ getmonthyear(tb_detail.getCreatedDate()) + "\r </span>\r\n"
					+ "														</div>\r\n"
					+ "														<div class=\"info-content\">\r\n"
					+ "															<a href=\"#\" class='openpdf'\" >"
					+ hidden + tb_detail.getDescription() + "</a>\r\n"
					+ "														</div>\r\n"
					+ "													</div>\r\n"
					+ "												</li>";

			formcounter++;

		}
		return values;
	}

	public String getDate(Date date1) throws ParseException {
		Date dateString = date1;

		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		SimpleDateFormat mainFormat = new SimpleDateFormat("dd");
		String mainDate = mainFormat.format(date1);
		return mainDate;
	}

	public String getmonthyear(Date date1) throws ParseException {
		Date dateString = date1;

		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		SimpleDateFormat subFormat = new SimpleDateFormat("MMM yyyy");
		String subDate = subFormat.format(date1);
		return subDate;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/getHallOfFame", method = RequestMethod.POST, produces = { "application/json" })
	public String getHallOfFame(@RequestBody String data, HttpServletRequest request) {
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";
		String roleName = request.getSession().getAttribute("role").toString();
		int recordsPerPage = 9;
		try {
			// Add Server Side Validation TODO
			jsonObject = (JSONObject) jsonp.parse(data);
			String currentPage = jsonObject.get("currentPage").toString();

			String sessionusername = request.getSession().getAttribute("username").toString();
			Integer userid = Integer.parseInt(sessionuserid);
			if (roleName.equalsIgnoreCase("USER")) {
				String instituteuserid = request.getSession().getAttribute("instituteuserid").toString();
				Optional<UserLogin> userlogin = userLoginRepository.findById(Integer.parseInt(instituteuserid));

				sessionusername = userlogin.get().getUserName();
				userid = Integer.parseInt(instituteuserid);
			}

			int offset = (Integer.parseInt(currentPage) - 1) * recordsPerPage;

			List<TbHallOfFame> getHallofFame = hallOfFameRepository.LoadHallOffameshowData(offset, recordsPerPage,
					userid);

			int j = 0;
			String notdata = "";
			if (getHallofFame.size() != 0) {

				for (int i = 0; i < getHallofFame.size(); i++) {

					j += 1;
					TbHallOfFame tbHallOfFame = getHallofFame.get(i);
					String hidden = "<input type='hidden' name='hidv" + j + "' id='hidv" + j + "' value='"
							+ Base64Service.encode(AESGCM.encrypt(String.valueOf(tbHallOfFame.getId())).getBytes())
							+ "' /> ";
					String Achievement = tbHallOfFame.getAchievement();
					String Hallimage = imageEncoderDecoder(tbHallOfFame.getPhoto());
					String halloffame = "\'data:image/jpeg;base64," + Hallimage + "\'";

					Optional<UserLogin> userLogin = userLoginRepository.findById(tbHallOfFame.getCreatedBy());
					List<TbRegistrationDetail> tbRegistrationDetail = registrationRepository
							.loadAlumninameData(userLogin.get().getUserName());

					String Country = "";
					String AlumniName = "";
					String PassoutYear = "";

					if (tbRegistrationDetail.size() != 0) {
						Country = tbRegistrationDetail.get(0).getCountryId().getCountryName();
						AlumniName = tbRegistrationDetail.get(0).getAlumniName();
//						PassoutYear = tbRegistrationDetail.get(0).getPassoutYear().toString();

						notdata += "<div class=\"col-lg-4 col-md-4 col-sm-12 col-12\">\r\n"
								+ "									<div class=\"card fame-cover\">\r\n"
								+ "										<div class=\"fame-imgwrapper\">\r\n"
								+ "											<div class=\"fame-img\">\r\n"
								+ "												<img class=\"img-fluid\" alt=\"\"\r\n"
								+ "													src=" + halloffame + ">\r\n"
								+ "											</div>\r\n"
								+ "										</div>\r\n"
								+ "										<div class=\"fame-infowrapper\">\r\n"
								+ "											<div class=\"alumini-info\">\r\n"
								+ "													<p class=\"country-info\">\r\n"
								+ "														<span class=\"dn-data\">"
								+ Country + "</span>\r\n"
								+ "													</p>\r\n"
								+ "												<p class=\"passout-info\">\r\n"
								+ "													Pass Out: <span class=\"dn-data\">"
								+ PassoutYear + "&nbsp</span>\r\n"
								+ "												</p>\r\n"
								+ "											</div>\r\n"
								+ "											<div class=\"alumini-dtl\">\r\n"
								+ "												<p class=\"alumini-name\">\r\n"
								+ "													<span class=\"almn-name fname\">"
								+ AlumniName + "</span>\r\n"
//		                		+ "													<span class=\"almn-name lname\">Surana</span>\r\n"
								+ "												</p>\r\n"
								+ "												<p class=\"achv-desc\">\r\n"
								+ Achievement + "												</p>\r\n"
								+ "											</div>\r\n"
								+ "										</div>\r\n"
								+ "									</div>\r\n" + "								</div>";
					} else {
						Country = "";
						AlumniName = userLogin.get().getUserName();
						PassoutYear = "";

						notdata += "<div class=\"col-lg-4 col-md-4 col-sm-12 col-12\">\r\n"
								+ "									<div class=\"card fame-cover\">\r\n"
								+ "										<div class=\"fame-imgwrapper\">\r\n"
								+ "											<div class=\"fame-img\">\r\n"
								+ "												<img class=\"img-fluid\" alt=\"\"\r\n"
								+ "													src=" + halloffame + ">\r\n"
								+ "											</div>\r\n"
								+ "										</div>\r\n"
								+ "										<div class=\"fame-infowrapper\">\r\n"
								+ "											<div class=\"alumini-info\">\r\n"
								+ "												<p class=\"\">\r\n"
								+ "													 <span class=\"dn-data\">"
								+ PassoutYear + "&nbsp</span>\r\n"
								+ "												</p>\r\n"
								+ "												<div class=\"country-dtl\">\r\n"
								+ "													<p class=\"country-info\">\r\n"
								+ "														 <span class=\"dn-data\">"
								+ Country + "</span>\r\n"
								+ "													</p>\r\n"
								+ "												</div>\r\n"
								+ "											</div>\r\n"
								+ "											<div class=\"alumini-dtl\">\r\n"
								+ "												<p class=\"alumini-name\">\r\n"
								+ "													<span class=\"almn-name fname\">"
								+ AlumniName + "</span>\r\n"
//			                		+ "													<span class=\"almn-name lname\">Surana</span>\r\n"
								+ "												</p>\r\n"
								+ "												<p class=\"achv-desc\">\r\n"
								+ Achievement + "												</p>\r\n"
								+ "											</div>\r\n"
								+ "										</div>\r\n"
								+ "									</div>\r\n" + "								</div>";
					}

				}

			}

			int HallofFameCount = hallOfFameRepository.LoadHallOffameshowData1(userid);

			jsonobjectout.put("HallofFameCounts", HallofFameCount);
			jsonobjectout.put("notdata", notdata);
			jsonobjectout.put("status", "1");
			jsonobjectout.put("message", " Hall Of Fame Successfully");
			returnstring = jsonobjectout.toJSONString();

		} catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", "Failure");
			returnstring = jsonobjectout.toJSONString();
		}

		return returnstring;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/getFFCAlumni", method = RequestMethod.POST, produces = { "application/json" })
	public String getFFCAlumni(@RequestBody String data, HttpServletRequest request) {
		String sessionUserId = request.getSession().getAttribute("userId_for_jnlp").toString();
		JSONObject jsonObject = new JSONObject();
		JSONObject jsonObjectOut = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		JSONParser jsonp = new JSONParser();
		String returnString = "";
		int recordsPerPage = 9;
		try {
			// Fetch alumni details
			jsonObject = (JSONObject) jsonp.parse(data);
			String currentPage = jsonObject.get("currentPage").toString();
			String sessionusername = request.getSession().getAttribute("username").toString();
			Integer userid = Integer.parseInt(sessionUserId);
//			String dashname = request.getSession().getAttribute("dashname").toString();
//			Integer instituteid = userLoginRepository.instituteid(dashname);
			Optional<UserLogin> userLogin = userLoginRepository.findById(userid);
			Userloginchild userloginchild = userloginchildRepositroy.findByuseridId(userLogin.get().getUserId());
			TbInstituteDetail institute=instituteRepository.getById(userloginchild.getUserId().getInstituteId());
			
			Integer aluminiinstituteid = instituteRepository.instituteid(institute.getInstituteName());
			int offset = (Integer.parseInt(currentPage) - 1) * recordsPerPage;
			List<TbRegistrationDetailChild> alumniDetails = registrationChildRepository.LoadAlumniDashboard(offset,recordsPerPage, aluminiinstituteid);

			int j = 0;
			String notData = "";
			if (!alumniDetails.isEmpty()) {

				for (TbRegistrationDetailChild detail : alumniDetails) {
					j += 1;
					Integer alumniid = userLoginRepository.instituteid(detail.getRegistrationId().getAlumniName());

					List<TbProfileDtl> tbprofile1 = profileRepository
							.profiledata(detail.getRegistrationId().getAlumniName());
					
					String alumniName = detail.getRegistrationId().getAlumniName();
					Integer passoutYear = detail.getPassoutYear();
					String contactNumber = detail.getRegistrationId().getContactNumber();
					String emailId = detail.getRegistrationId().getEmailId();
					if (tbprofile1.size() != 0) {

						String Alumniimage = imageEncoderDecoder(tbprofile1.get(0).getPhoto());
						String Alumniimage1 = "\'data:image/jpeg;base64," + Alumniimage + "\'";
						notData += "<div class=\"col-xl-4 col-lg-6 col-md-6 col-sm-12 col-12\">\r\n"
								+ "  <div class=\"card profile-card\">\r\n" + "    <div class=\"profile-image\">\r\n"
								+ "      <img class=\"img-fluid\" src=" + Alumniimage1 + ">\r\n" + "    </div>\r\n"
								+ "    <div class=\"profile-info\">\r\n" + "      <div class=\"profile-name\">\r\n"
								+ "        <h2>" + alumniName + "</h2>\r\n" + "      </div>\r\n"
								+ "      <div class=\"profile-dtl\">\r\n"
								+ "        <p><i class=\"fa fa-graduation-cap\"></i>PassOut Year : <span class=\"dn-dtl\">"
								+ passoutYear + "</span></p>\r\n"
								+ "        <p><i class=\"fa fa-phone-volume\"></i>Contact No : <span class=\"dn-dtl\">"
								+ contactNumber + "</span></p>\r\n"
								+ "        <p><i class=\"fa fa-envelope\"></i>Email ID : <span class=\"dn-dtl\">"
								+ emailId + "</span></p>\r\n" + "      </div>\r\n" + "    </div>\r\n" + "  </div>\r\n"
								+ "</div>";

					} else {
						notData += "<div class=\"col-xl-4 col-lg-6 col-md-6 col-sm-12 col-12\">\r\n"
								+ "  <div class=\"card profile-card\">\r\n" + "    <div class=\"profile-image\">\r\n"
								+ "      <img class=\"img-fluid\" src=\"assets/images/no-user.png\">\r\n"
								+ "    </div>\r\n" + "    <div class=\"profile-info\">\r\n"
								+ "      <div class=\"profile-name\">\r\n" + "        <h2>" + alumniName + "</h2>\r\n"
								+ "      </div>\r\n" + "      <div class=\"profile-dtl\">\r\n"
								+ "        <p><i class=\"fa fa-graduation-cap\"></i>PassOut Year : <span class=\"dn-dtl\">"
								+ passoutYear + "</span></p>\r\n"
								+ "        <p><i class=\"fa fa-phone-volume\"></i>Contact No : <span class=\"dn-dtl\">"
								+ contactNumber + "</span></p>\r\n"
								+ "        <p><i class=\"fa fa-envelope\"></i>Email ID : <span class=\"dn-dtl\">"
								+ emailId + "</span></p>\r\n" + "      </div>\r\n" + "    </div>\r\n" + "  </div>\r\n"
								+ "</div>";
					}

				}
			}

			int AlumniCount = registrationRepository.LoadAlumniDashboard1(aluminiinstituteid);
			jsonObjectOut.put("AlumniCount", AlumniCount);
			jsonObjectOut.put("notdata", notData);
			jsonObjectOut.put("status", "1");
			jsonObjectOut.put("message", "Alumni Successfully");

			returnString = jsonObjectOut.toJSONString();

		} catch (Exception e) {
			e.printStackTrace();
			jsonObjectOut.put("status", "0");
			jsonObjectOut.put("message", "Failure");
			returnString = jsonObjectOut.toJSONString();
		}

		return returnString;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/getpicturegallary", method = RequestMethod.POST, produces = { "application/json" })
	public String getpicturegallary(@RequestBody String data, HttpServletRequest request) {
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";

		int recordsPerPage = 6;
		try {
			// Add Server Side Validation TODO
			jsonObject = (JSONObject) jsonp.parse(data);
			String currentPage = jsonObject.get("currentPage").toString();
			String sessionusername = request.getSession().getAttribute("username").toString();
			Integer userid = Integer.parseInt(sessionuserid);
			String roleName = request.getSession().getAttribute("role").toString();
			if (roleName.equalsIgnoreCase("USER")) {
				String instituteuserid = request.getSession().getAttribute("instituteuserid").toString();
				Optional<UserLogin> userlogin = userLoginRepository.findById(Integer.parseInt(instituteuserid));

				sessionusername = userlogin.get().getUserName();
				userid = Integer.parseInt(instituteuserid);
			}
			int offset = (Integer.parseInt(currentPage) - 1) * recordsPerPage;
			List<TbPictureGallary> getpicturedata = photoGallaryRepository.LoadPhotoGallaryData(offset, recordsPerPage,
					userid);

			int j = 0;
			String notdata = "";
			if (getpicturedata.size() != 0) {
				notdata += "<ul id=\"lightgallery\" class=\"row\">";
				for (int i = 0; i < getpicturedata.size(); i++) {

					j += 1;
					TbPictureGallary tbHallOfFame = getpicturedata.get(i);
					String hidden = "<input type='hidden' name='hidv" + j + "' id='hidv" + j + "' value='"
							+ Base64Service.encode(AESGCM.encrypt(String.valueOf(tbHallOfFame.getId())).getBytes())
							+ "' /> ";
					String description = tbHallOfFame.getDescription();
					String category = tbHallOfFame.getCategory();
					String photosrc = tbHallOfFame.getImageUpload();
					String Photoimage = imageEncoderDecoder(tbHallOfFame.getImageUpload());
					String photogallary = "'data:image/jpeg;base64," + Photoimage + "'";

					notdata += "<li class=\"col-lg-4 col-md-6 col-sm-12 col-12\" " + "data-sub-html=\"<h4>" + category
							+ "</h4><p>" + description + "</p>\" " + "data-src=" + photogallary + ">"
							+ "<div class=\"img-body\">" + "<div class=\"title-wrapper\">" + "<p class=\"title\">"
							+ category + "</p>" + "</div>" + "<div class=\"img-wrapper\">"
							+ "<img class=\"img-fluid\" src=" + photogallary + ">" + "</div>"
							+ "<div class=\"desc-wrapper\">" + "<p class=\"desc\">" + description + "</p>" + "</div>"
							+ "</div>" + "</li>";

				}
				notdata += "</ul>";
			}

			int photogallaryCount = photoGallaryRepository.LoadphotogallaryshowData1(userid);

			jsonobjectout.put("photogallaryCount", photogallaryCount);
			jsonobjectout.put("notdata", notdata);
			jsonobjectout.put("status", "1");
			jsonobjectout.put("message", " Photo Gallary Successfully");
			returnstring = jsonobjectout.toJSONString();

		} catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", "Failure");
			returnstring = jsonobjectout.toJSONString();
		}

		return returnstring;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/getMiscActivity", method = RequestMethod.POST, produces = { "application/json" })
	public String getMiscActivity(@RequestBody String data, HttpServletRequest request) {
		String sessionUserId = request.getSession().getAttribute("userId_for_jnlp").toString();
		JSONObject jsonObject = new JSONObject();
		JSONObject jsonObjectOut = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		JSONParser jsonp = new JSONParser();
		String returnString = "";
		int recordsPerPage = 3;
		try {
			// Fetch activity details
			jsonObject = (JSONObject) jsonp.parse(data);
			String currentPage = jsonObject.get("currentPage").toString();
			int offset = (Integer.parseInt(currentPage) - 1) * recordsPerPage;
			String sessionusername = request.getSession().getAttribute("username").toString();
			Integer userid = Integer.parseInt(sessionUserId);
			String roleName = request.getSession().getAttribute("role").toString();
			if (roleName.equalsIgnoreCase("USER")) {
				String instituteuserid = request.getSession().getAttribute("instituteuserid").toString();
				Optional<UserLogin> userlogin = userLoginRepository.findById(Integer.parseInt(instituteuserid));

				sessionusername = userlogin.get().getUserName();
				userid = Integer.parseInt(instituteuserid);
			}
			List<TbMiscActivity> activityDetails = activityRepository.LoadActivityDashboard(offset, recordsPerPage,
					userid);
			int j = 0;
			String miscData = "";
			if (!activityDetails.isEmpty()) {

				for (int i = 0; i < activityDetails.size(); i++) {
					j += 1;
					TbMiscActivity tbMiscActivity = activityDetails.get(i);

					Optional<UserLogin> tbMiscOptional = userLoginRepository.findById(tbMiscActivity.getCreatedBy());

					String hidden = "<input type='hidden' name='hidv" + j + "' id='hidv" + j + "' value='"
							+ Base64Service.encode(AESGCM.encrypt(String.valueOf(tbMiscActivity.getId())).getBytes())
							+ "' /> ";
					TbMiscActivity tb_dateee = new TbMiscActivity();
					String blogid = AESGCM.encrypt(tbMiscActivity.getId().toString());
					String miscPhoto = imageEncoderDecoder(tbMiscActivity.getMiscPhoto());
					String miscimage = imageEncoderDecoder(tbMiscActivity.getImage());
					String miscActivityimage = "\'data:image/jpeg;base64," + miscimage + "\'";
					String miscActivityPhoto = "\'data:image/jpeg;base64," + miscPhoto + "\'";
					String miscTitle = tbMiscActivity.getMiscTitle();
					String createdBy = tbMiscOptional.get().getUserName();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					TbNewsLetter tb_detail = new TbNewsLetter();
					tb_detail.setCreatedDate((tbMiscActivity.getCreatedDate()));
					//String year = tbMiscActivity.getYear();
					String year = "";
					String miscDescription = tbMiscActivity.getMiscDescription();
					String path = tbMiscActivity.getMiscPhoto();
					String[] bits = path.split("\\.(?=[^\\.]+$)");
					
					System.out.println("ID: " + tbMiscActivity.getId() + ", Created Date: " + tbMiscActivity.getCreatedDate());

					String docType = bits[bits.length - 1];

					if (docType.equalsIgnoreCase("jpeg") || docType.equalsIgnoreCase("jpg") || docType.equalsIgnoreCase("png")) {
					    miscData += "<div class=\"col-lg-12 col-md-12 col-sm-12 col-12\">\r\n"
					            + "  <div class=\"card blog-card\">\r\n"
					            + "    <div class=\"blog-image\">\r\n"
					            + "<a href=\"#\" class=\"open-image\" data-image="+miscActivityPhoto+">"
						         + "<img class=\"img-fluid\" src=" + miscActivityPhoto + " title=\"" + miscTitle + "\">"
						         + "</a>"
					            + "    </div>\r\n"
					            + "    <div class=\"blog-info\">\r\n"
					            + "      <div class=\"blog-ttl\">\r\n"
					            + "        <a class='blog-ttl-wraper' href='#' title=\"" + miscTitle + "\">"+ "Title:-" + miscTitle + "</a>\r\n"
					            + "      </div>\r\n"
					            + "      <div class=\"blog-dtl\">\r\n"
					            + "        <p class=\"blog-auth-dtl\">By <span class=\"blog-auth\">" + createdBy + "</span>\r\n"
					            + "           <span class=\"auth-passout\">" + tb_detail.getCreatedDate() + "</span>\r\n"
					            + "        </p>\r\n"
					            + "        <div class=\"blog-desc " + (miscDescription.length() >= 200 ? "read-more-container" : "") + "\">\r\n"
					            + "          <p class=\"" + (miscDescription.length() >= 200 ? "read-more-text read-less" : "") + "\" id=\"read-more-text\" title=\"" + miscDescription + "\">"+ "Description:-" + miscDescription + "</p>\r\n"
					            + (miscDescription.length() >= 200 ? "<span class=\"read-more-btn\" id=\"read-more-btn\">Read more..</span>\r\n" : "")
					            + "        </div>\r\n"
					            + "      </div>\r\n"
					            + "    </div>\r\n"
					            + "  </div>\r\n"
					            + "</div>";
					} else if (docType.equalsIgnoreCase("pdf")) {
					    miscData += "<div class=\"col-lg-12 col-md-12 col-sm-12 col-12\">\r\n"
					            + "  <div class=\"card blog-card\">\r\n"
					            + "    <a href=\"#\" class=\"blog-image\" title=\"View PDF\">\r\n"
					            + "      <img class=\"img-fluid\" src=" + miscActivityimage + " title=\"" + miscTitle + "\">\r\n"
					            + "      <span class=\"blog-ol\">\r\n"
					            + "        <span class=\"pdf-block opendocument\" value=" + blogid + " title=\"" + hidden + "\">" + hidden + "\r\n"
					            + "          <span class=\"pdf-icon\"></span>\r\n"
					            + "        </span>\r\n"
					            + "      </span>\r\n"
					            + "    </a>\r\n"
					            + "    <div class=\"blog-info\">\r\n"
					            + "      <div class=\"blog-ttl\">\r\n"
					            /*+ "        <p>Title:-</p>\r\n"*/
					            + "        <a class=\"blog-ttl-wraper\" href=\"#\" title=\"" + miscTitle + "\">"+"Title:-" + miscTitle + "</a>\r\n"
					            + "      </div>\r\n"
					            + "      <div class=\"blog-dtl\">\r\n"
					            + "        <p class=\"blog-auth-dtl\">By <span class=\"blog-auth\">" + createdBy + "</span>\r\n"
					            + "           <span class=\"auth-passout\">" + tb_detail.getCreatedDate() + "</span>\r\n"
					            + "        </p>\r\n"
					            + "        <div class=\"" + (miscDescription.length() >= 200 ? "blog-desc read-more-container" : "blog-desc") + "\">\r\n"
					            + "          <p class=\"" + (miscDescription.length() >= 200 ? "read-more-text read-less" : "") + "\" id=\"read-more-text\" title=\"" + miscDescription + "\"> "+ "Description:-" + miscDescription + "</p>\r\n"
					            + (miscDescription.length() >= 200 ? "<span class=\"read-more-btn\" id=\"read-more-btn\">Read more...</span>\r\n" : "")
					            + "        </div>\r\n"
					            + "      </div>\r\n"
					            + "    </div>\r\n"
					            + "  </div>\r\n"
					            + "</div>";
					}


					else if (docType.equalsIgnoreCase("mp4")) {

						miscData += "<div class=\"col-lg-12 col-md-12 col-sm-12 col-12\">\r\n"
								+ "				<div class=\"card blog-card\">\r\n"
								+ "					<a href=\"#\"  class=\"blog-image\" title=\"View Video\"> <img\r\n"
								+ "						class=\"img-fluid\" src=" + miscActivityimage + ">\r\n"
								+ "						<span class=\"blog-ol\">\r\n"
								+ "							<button class=\"video-btn opendocument\" value=" + blogid
								+ ">\r\n" + hidden + "								<i class=\"ri-video-line\"></i>\r\n"
								+ "							</button>\r\n" + "					</span>\r\n"
								+ "					</a>\r\n" + "					<div class=\"blog-info\">\r\n"
								+ "						<div class=\"blog-ttl\">\r\n"
								+ "							<a class=\"blog-ttl-wraper\" href=\"#\">" + miscTitle
								+ "</a>\r\n" + "						</div>\r\n"
								+ "						<div class=\"blog-dtl\">\r\n"
								+ "							<p class=\"blog-auth-dtl\">\r\n"
								+ "								By <span class=\"blog-auth\">" + createdBy
								+ "</span><span\r\n" + "									class=\"auth-passout\">"
								+ year + "</span>\r\n" + "							</p>\r\n"
								+ "							<div class=\""
								+ (miscDescription.length() >= 200 ? "blog-desc read-more-container" : "blog-desc")
								+ "\">" + "								<p class=\""
								+ (miscDescription.length() >= 200 ? "read-more-text read-less" : "")
								+ "\" id=\"read-more-text\">" + miscDescription + "</p>\r\n"
								+ (miscDescription.length() >= 200
										? "<span class=\"read-more-btn\" id=\"read-more-btn\">Read\r\n"
												+ "									More...</span>\r\n"
										: "")
								+ "							</div>\r\n" + "						</div>\r\n"
								+ "					</div>\r\n" + "				</div>\r\n" + "			</div>";

					}
				}
			}

			int ActivityCount = activityRepository.LoadActivityDashboard1(userid);

			int totalPages = (int) Math.ceil((double) ActivityCount / recordsPerPage);
			jsonObjectOut.put("ActivityCount", ActivityCount);
			jsonObjectOut.put("TotalPages", totalPages);
			jsonObjectOut.put("miscData", miscData);
			jsonObjectOut.put("status", "1");
			jsonObjectOut.put("message", "Activity Successfully");

			returnString = jsonObjectOut.toJSONString();

		} catch (Exception e) {
			e.printStackTrace();
			jsonObjectOut.put("status", "0");
			jsonObjectOut.put("message", "Failure");
			returnString = jsonObjectOut.toJSONString();
		}

		return returnString;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/getEjournal", method = RequestMethod.POST, produces = { "application/json" })
	public String getEjournal(@RequestBody String data, HttpServletRequest request) {
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";

		int recordsPerPage = 4;
		try {
			// Fetch journal details
			jsonObject = (JSONObject) jsonp.parse(data);
			String currentPage = jsonObject.get("currentPage").toString();
			String sessionusername = request.getSession().getAttribute("username").toString();
			Integer userid = Integer.parseInt(sessionuserid);
			Optional<UserLogin> userLogin = userLoginRepository.findById(Integer.parseInt(sessionuserid));
			String roleName = request.getSession().getAttribute("role").toString();
			if (roleName.equalsIgnoreCase("USER")) {
				String instituteuserid = request.getSession().getAttribute("instituteuserid").toString();

				sessionusername = userLogin.get().getUserName();
				userid = Integer.parseInt(instituteuserid);
			}

			int offset = (Integer.parseInt(currentPage) - 1) * recordsPerPage;
			List<TbUserAlumniEjournal> journalDetails = userEjournalRepository.LoadJournalDashboard(offset,recordsPerPage,templet.queryForObject(
				"SELECT institute_id FROM userloginchild WHERE user_id = ? limit 1",
				new Object[]{userLogin.get().getUserId()}, 
				Integer.class
			));

			int j = 0;
			String journaldata = "";

			if (journalDetails.size() != 0) {
				for (int i = 0; i < journalDetails.size(); i++) {
					// journal
					j += 1;
					TbUserAlumniEjournal tbUserAlumniEjournal = journalDetails.get(i);
					String hidden = "<input type='hidden' name='hidv" + j + "' id='hidv" + j + "' value='"
							+ Base64Service.encode(
									AESGCM.encrypt(String.valueOf(tbUserAlumniEjournal.getId())).getBytes())
							+ "' /> ";
					String coverphoto = imageEncoderDecoder(tbUserAlumniEjournal.getCoverPhoto());
					String coverphoto1 = "\'data:image/jpeg;base64," + coverphoto + "\'";
					Integer id = tbUserAlumniEjournal.getId();

					journaldata += "<div class=\"col-lg-3 col-md-4 col-sm-6 col-12\">"
							+ "    <div class=\"card custom-j-card mb-0\">" + "        <div class=\"card-cover\">"
							+ "            <img class=\"img-fluid\" alt=\"Journal\" src=" + coverphoto1 + ">"
							+ "        </div>" + "        <a href=\"../admin/E_Journal_dtlPage?id=" + id
							+ "\" class=\"overlay-content\"" + "            title=\"Click here\" >"
							+ "            <span class=\"oc-text\">Read Now</span> <span class=\"oc-icon\"><i class=\"fa fa-angle-right\"></i></span>"
							+ "        </a>" + "    </div>" + "</div>";

				}
			}

			int Ejournalcount = userEjournalRepository.LoadJournalDashboard1(userid);
			int totalPages = (int) Math.ceil((double) Ejournalcount / recordsPerPage);

			jsonobjectout.put("Ejournalcount", Ejournalcount);
			jsonobjectout.put("journaldata", journaldata);
			jsonobjectout.put("status", "1");
			jsonobjectout.put("message", "E-Journal Successfully");
			returnstring = jsonobjectout.toJSONString();
		} catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", "Failure");
			returnstring = jsonobjectout.toJSONString();
		}

		return returnstring;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/getEjournaldtl", method = RequestMethod.GET, produces = "application/json")
	public String getEjournaldtl(@RequestParam("id") int id, HttpServletRequest request) {
		JSONObject responseJson = new JSONObject();
		JSONObject jsonobjectout = new JSONObject();

		try {
			String sessionUserId = request.getSession().getAttribute("userId_for_jnlp").toString();

			Optional<TbUserAlumniEjournal> journalOpt = userEjournalRepository.findById(id);
			String journaldtl = "";
			if (journalOpt.isPresent()) {
				TbUserAlumniEjournal journal = journalOpt.get();

				String coverPhoto = "data:image/jpeg;base64," + imageEncoderDecoder(journalOpt.get().getCoverPhoto());
				String uploadPdf = "data:image/pdf;base64," + imageEncoderDecoder(journalOpt.get().getUploadPdf());
				String publisher = journalOpt.get().getPublisher().toString();
				String author = journalOpt.get().getAuthor().toString();
				String publisherDate = journalOpt.get().getPublisherDate().toString();
				Integer bookLength = journalOpt.get().getBookLength();
				String description = journalOpt.get().getDescription();
				String language = journalOpt.get().getLanguage();
				String name = journalOpt.get().getName();

				String hidden = "<input type='hidden' name='hid' id='hid'" + " value='"
						+ Base64Service.encode(AESGCM.encrypt(String.valueOf(journalOpt.get().getId())).getBytes())
						+ "' /> ";
				String hiddid = Base64Service
						.encode(AESGCM.encrypt(String.valueOf(journalOpt.get().getId())).getBytes());

				journaldtl += "<div class=\"col-lg-3 col-md-3 col-sm-12 col-12\">\r\n"
						+ "                                    <div class=\"custom-jcover-wrapper\">\r\n"
						+ "                                        <div class=\"custom-jcover\">\r\n"
						+ "                                            <img class=\"img-fluid\" alt=\"Journal\"\r\n"
						+ "                                                src=\" " + coverPhoto + " \" />"
						+ "                                        </div>\r\n"
						+ "                     <div class=\"journalpdf1\">                   <div class=\"jcover-btn journalpdf3 \">\r\n"
						+ "                                            <a href=\"#\" class=\"btn btn-primary journalpdf2 journalpdf1\" value="
						+ hiddid + ">\r\n"
						+ "                                                <i class=\"ri-book-open-fill journalpdf journalpdf1\">"
						+ "<span class=\"btn-text journalpdf1\">Read Now</span></i>\r\n"
						+ "                                            </a>\r\n" + hidden
						+ "                                        </div></div>\r\n"
						+ "                                    </div>\r\n"
						+ "                                </div>\r\n"
						+ "                                <div class=\"col-lg-9 col-md-9 col-sm-12 col-12\">\r\n"
						+ "                                    <div class=\"custom-jinfo\">\r\n"
						+ "                                        <div class=\"custom-jinfo-detblc\">\r\n"
						+ "                                            <h3 class=\"custom-detblc-title\">" + name
						+ "</h3>\r\n"
						+ "                                            <p class=\"custom-detblc-text\">\r\n"
						+ "                                                <span class=\"text-black-hl\">By</span> <span\r\n"
						+ "                                                    class=\"text-heighlight\">" + author
						+ "</span>\r\n" + "                                            </p>\r\n"
						+ "                                        </div>\r\n"
						+ "                                        <div class=\"custom-jinfo-ext\">\r\n"
						+ "                                            <ul class=\"custom-det-list\">\r\n"
						+ "                                                <li class=\"custom-det-item\"><span\r\n"
						+ "                                                    class=\"custom-data-value\"> <span\r\n"
						+ "                                                        class=\"custom-data-title\"> <span\r\n"
						+ "                                                            class=\"custom-dt-i\"><i class=\"fa fa-user\"></i></span>Publisher:\r\n"
						+ "                                                    </span> <span class=\"custom-data-text\">"
						+ publisher + "</span>\r\n" + "                                                </span></li>\r\n"
						+ "                                                <li class=\"custom-det-item\"><span\r\n"
						+ "                                                    class=\"custom-data-value\"><span\r\n"
						+ "                                                        class=\"custom-data-title\"><span class=\"custom-dt-i\"><i\r\n"
						+ "                                                                class=\"fa fa-calendar\"></i></span>Publication Date:</span><span\r\n"
						+ "                                                        class=\"custom-data-text\">"
						+ publisherDate.toString() + "</span></span></li>\r\n"
						+ "                                                <li class=\"custom-det-item\"><span\r\n"
						+ "                                                    class=\"custom-data-value\"><span\r\n"
						+ "                                                        class=\"custom-data-title\"><span class=\"custom-dt-i\"><i\r\n"
						+ "                                                                class=\"fa fa-language\"></i></span>Language:</span><span\r\n"
						+ "                                                        class=\"custom-data-text\">"
						+ language + "</span></span></li>\r\n"
						+ "                                                <li class=\"custom-det-item\"><span\r\n"
						+ "                                                    class=\"custom-data-value\"><span\r\n"
						+ "                                                        class=\"custom-data-title\"><span class=\"custom-dt-i\"><i\r\n"
						+ "                                                                class=\"fa fa-book\"></i></span>Book Length:</span><span\r\n"
						+ "                                                        class=\"custom-data-text\">"
						+ bookLength + "</span></span></li>\r\n"
						+ "                                            </ul>\r\n"
						+ "                                            <p class=\"custom-detblc-text\">" + description
						+ "</p>\r\n" + "                                        </div>\r\n"
						+ "                                    </div>\r\n" + "                                </div>";

				jsonobjectout.put("status", "1");
				jsonobjectout.put("message", "E-Journal Successfully");
				jsonobjectout.put("journaldtl", journaldtl);
			} else {
				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "Journal not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", "Failure");
		}
		return jsonobjectout.toJSONString();
	}

	@ResponseBody
	@RequestMapping(value = "/admin/getwhatsnewscroll", method = RequestMethod.POST, produces = { "application/json" })
	public String getwhatsnewscroll(HttpServletRequest request) {
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";

		try {
			// Add Server Side Validation TODO

			String sessionusername = request.getSession().getAttribute("username").toString();
			Integer userid = Integer.parseInt(sessionuserid);
			Integer instituteid = userLoginRepository.instituteid(sessionusername);
			String roleName = request.getSession().getAttribute("role").toString();
			if (roleName.equalsIgnoreCase("USER")) {
				String instituteuserid = request.getSession().getAttribute("instituteuserid").toString();
				Optional<UserLogin> userlogin = userLoginRepository.findById(Integer.parseInt(instituteuserid));

				sessionusername = userlogin.get().getUserName();
				userid = Integer.parseInt(instituteuserid);
			}

			List<TbWhatsNewScroll> getwhatsnewscrolldata = whatsNewScrollRepository.LoadWhatsNewScrollData(userid);
			int j = 0;
			String notdata = "";

			if (getwhatsnewscrolldata.size() != 0) {
				for (int i = 0; i < getwhatsnewscrolldata.size(); i++) {

					j += 1;
					TbWhatsNewScroll tbwhatsnewscroll = getwhatsnewscrolldata.get(i);

					String hidden = "<input type='hidden' name='hidv" + j + "' id='hidv" + j + "' value='"
							+ Base64Service.encode(AESGCM.encrypt(String.valueOf(tbwhatsnewscroll.getId())).getBytes())
							+ "' /> ";
					String description = tbwhatsnewscroll.getDescription();
					Boolean check = Arrays.stream(new String[] {"http://","https://"}).anyMatch(description::contains);
					notdata += "<li>"+(check ?"<a target=\"_blank\" href="+description+">" + description + " </a>":"<p>"+description+"</p>")+"</li>\r\n";

				}
			}

			jsonobjectout.put("notdata", notdata);
			jsonobjectout.put("status", "1");
			jsonobjectout.put("message", "Whats News Successfully");
			returnstring = jsonobjectout.toJSONString();

		} catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", "Failure");
			returnstring = jsonobjectout.toJSONString();
		}

		return returnstring;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/getwhatsnewscrollforuser", method = RequestMethod.POST, produces = {
			"application/json" })
	public String getwhatsnewscrollforuser(HttpServletRequest request, @RequestBody String data) {
		String sessionuserid = request.getSession().getAttribute("userId_for_jnlp").toString();
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONParser jsonp = new JSONParser();
		JSONObject jsonobjectout = new JSONObject();
		String returnstring = "";

		try {
			// Add Server Side Validation TODO
			jsonObject = (JSONObject) jsonp.parse(data);
			String sessionusername = request.getSession().getAttribute("username").toString();
			Integer userid = Integer.parseInt(sessionuserid);
			Integer instituteid = userLoginRepository.instituteid(sessionusername);
			String roleName = request.getSession().getAttribute("role").toString();
			if (roleName.equalsIgnoreCase("USER")) {

				instituteid = Integer.parseInt(jsonObject.get("institute").toString());
				Optional<TbInstituteDetail> tbInstituteDetail = instituteRepository.findById(instituteid);

				UserLogin userLogin = userLoginRepository.findUserinstituteFromInsID(instituteid);

				Optional<UserLogin> userlogin = userLoginRepository.findById(userLogin.getUserId());

				sessionusername = userlogin.get().getUserName();
				userid = userLogin.getUserId();
			}

			List<TbWhatsNewScroll> getwhatsnewscrolldata = whatsNewScrollRepository.LoadWhatsNewScrollData(userid);
			int j = 0;
			String notdata = "";
			Userloginchild userloginchild = userloginchildRepositroy
					.findByuserinstitueid(Integer.parseInt(sessionuserid), instituteid);
			if (userloginchild != null) {
				if (getwhatsnewscrolldata.size() != 0) {
					for (int i = 0; i < getwhatsnewscrolldata.size(); i++) {

						j += 1;
						TbWhatsNewScroll tbwhatsnewscroll = getwhatsnewscrolldata.get(i);

						String hidden = "<input type='hidden' name='hidv" + j + "' id='hidv" + j + "' value='"
								+ Base64Service.encode(
										AESGCM.encrypt(String.valueOf(tbwhatsnewscroll.getId())).getBytes())
								+ "' /> ";
						String description = tbwhatsnewscroll.getDescription();
						Boolean check = Arrays.stream(new String[] {"http","https"}).anyMatch(description::contains);
						notdata += "<li>"+(check ?"<a target=\"_blank\" href="+description+">" + description + " </a>":"<p>"+description+"</p>")+"</li>\r\n";

					}
				}

				jsonobjectout.put("notdata", notdata);
				jsonobjectout.put("status", "1");
				jsonobjectout.put("message", "Whats News Successfully");
				returnstring = jsonobjectout.toJSONString();

			} else {
				jsonobjectout.put("status", "0");
				jsonobjectout.put("message", "Unauthorized Access");
				returnstring = jsonobjectout.toJSONString();
			}

		} catch (Exception e) {
			e.printStackTrace();
			jsonobjectout.put("status", "0");
			jsonobjectout.put("message", "Failure");
			returnstring = jsonobjectout.toJSONString();
		}

		return returnstring;
	}

}