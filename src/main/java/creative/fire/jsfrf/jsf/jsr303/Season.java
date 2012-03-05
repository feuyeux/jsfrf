package creative.fire.jsfrf.jsf.jsr303;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@Constraint(validatedBy = { SeasonValidator.class })
@Documented
@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Season {
	Class<?>[] groups() default {};

	String message() default "季节只能是  'spring', 'summer', 'fall', 或者 'winter'";

	Class<? extends Payload>[] payload() default {};
}