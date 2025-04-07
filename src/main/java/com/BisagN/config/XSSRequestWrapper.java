package com.BisagN.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang.StringEscapeUtils;

public class XSSRequestWrapper extends HttpServletRequestWrapper {

	public XSSRequestWrapper(HttpServletRequest servletRequest) {
		super(servletRequest);
	}

	@Override
	public String[] getParameterValues(String parameter) {
		String[] values = super.getParameterValues(parameter);
		if (values == null) {

			return null;
		}

		int count = values.length;
		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
//			if (values[i] != null && !values[i].equalsIgnoreCase("")) {
//				
//				System.err.println("values[i].toString().substring(0)"+values[i].toString().substring(0,1));
//				
//				if (values[i].toString().substring(0,1).equalsIgnoreCase("{")
//						|| values[i].toString().substring(0,1).equalsIgnoreCase("[")) {
//					encodedValues[i] = stripXSS(values[i]);
//
//					encodedValues[i]=values[i].replaceAll("&quot;", "\"");
//				} else {
//					encodedValues[i] = stripXSS(values[i]);
//				}
//			} else {
			encodedValues[i] = stripXSS(values[i]);
			// }
//			System.err.println("values = = " + values[i]);

		}

		return encodedValues;
	}

	@Override
	public String getParameter(String parameter) {
		String value = super.getParameter(parameter);

		return stripXSS(value);
	}

	private String stripXSS(String value) {
		if (value != null) {

			value = value.replaceAll("", "");
			Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			scriptPattern = Pattern.compile("<style>(.*?)</style>", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			scriptPattern = Pattern.compile("<script(.*?)>",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			scriptPattern = Pattern.compile("eval\\((.*?)\\)",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			scriptPattern = Pattern.compile("expression\\((.*?)\\)",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			scriptPattern = Pattern.compile("onload(.*?)=",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			value = StringEscapeUtils.escapeHtml(value);

			if (value.contains("'")) {
				value = value.replace("'", "");
			}
			if (value.contains("\"")) {
				value = value.replace("\"", "");
			}

			if (value.contains("(")) {
				value = value.replace("(", "");
			}
			if (value.contains(")")) {
				value = value.replace(")", "");
			}

			if (value.contains("<")) {
				value = value.replace("<", "");
			}
			if (value.contains(">")) {
				value = value.replace(">", "");
			}
			if (value.contains("&lt;")) {
				value = value.replace("&lt;", "");
			}
			if (value.contains("&gt;")) {
				value = value.replace("&gt;", "");
			}

//			if (value.contains("=")) {
//				value = value.replace("=", "");
//			}

			if (XSSRequestWrapper.containsCsvInjection(value)) {
				if (value.contains("+")) {
					value = value.replace("+", "");
				}
				if (value.contains("-")) {
					value = value.replace("-", "");
				}

				if (value.contains("=")) {
					value = value.replace("=", "");
				}

				if (value.contains("*")) {
					value = value.replace("*", "");
				}
				if (value.contains("/")) {
					value = value.replace("/", "");
				}
				if (value.contains("%")) {
					value = value.replace("%", "");
				}
				if (value.contains("^")) {
					value = value.replace("^", "");
				}
			}

			if (value != null && !value.equalsIgnoreCase("")) {
				if (value.toString().substring(0, 1).equalsIgnoreCase("{")
						|| value.toString().substring(0, 1).equalsIgnoreCase("[")) {

					value = value.replaceAll("&quot;", "\"");
				}
			}

		}
		return value;
	}

	public static boolean containsCsvInjection(String value) {
		Pattern CSV_INJECTION_PATTERN = Pattern.compile(
				"(?i)(?:^|[^\\w])(=)[\\s]*((SUM|SUBTRACT|DIVIDE|MULTIPLY|IF|AND|OR|NOT|XOR|IFERROR|VLOOKUP|HLOOKUP|LOOKUP|MATCH|INDEX|OFFSET|CONCATENATE|TEXT|LEFT|RIGHT|MID|LEN|UPPER|LOWER|TRIM|SEARCH|FIND|SUBSTITUTE|REPLACE|TRUE|FALSE|NOW|TODAY|DATE|TIME|DAY|MONTH|YEAR|HOUR|MINUTE|SECOND|DATEDIF|EDATE|EOMONTH|WEEKDAY|PV|FV|PMT|NPV|IRR|STDEV|VAR|MEDIAN|MODE|RANK|PERCENTILE|QUARTILE|CELL|ISERROR|ISBLANK|NA)[\\s]*\\([\\s]*.*\\)|[0-9\\s]*[+\\-*/><=]{1,2}[\\s]*[0-9\\s]*)",
				Pattern.CASE_INSENSITIVE);

		// Use the regular expression to detect dangerous values
		Matcher matcher = CSV_INJECTION_PATTERN.matcher(value);
		return matcher.find();
	}
}