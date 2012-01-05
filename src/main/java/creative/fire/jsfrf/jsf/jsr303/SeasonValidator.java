package creative.fire.jsfrf.jsf.jsr303;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SeasonValidator implements ConstraintValidator<Season, String> {
	private final String[] seasons = { "spring", "summer", "fall", "winter" };

	public void initialize(Season status) {
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (Arrays.asList(seasons).contains(value))
			return true;
		return false;
	}
}
