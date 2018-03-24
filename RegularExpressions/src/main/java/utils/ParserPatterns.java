package utils;

/**
 * Created by Denis on 24.03.2018.
 */
public interface ParserPatterns {
    String NAME_STRING_PATTERN = "^(([a-zA-Z]+)\\s+([a-zA-Z]+)\\s+)\\d+";
    String BIRTHDAY_STRING_PATTERN = "\\s+((0?[1-9]|[12][0-9]|3[01])(,|.|-)((0?[1-9]|1[012]))(,|.|-)(19|20)\\d{2})\\s+";
    String PHONE_STRING_PATTERN = "\\s(\\+?(\\d\\d)?\\(?\\d{3}\\)?(\\s|-)?\\d{3}((\\s|-)?\\d{2}){2})";
    String ADDRESS_STRING_PATTERN = "\\s+([a-zA-Z]+,?\\s+[a-zA-Z.-]+,?(-|\\s)+\\d+/?\\d+(,|-|/|\\s)?\\d*)";
}
