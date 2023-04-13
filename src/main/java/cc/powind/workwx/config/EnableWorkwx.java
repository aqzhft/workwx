package cc.powind.workwx.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(WorkwxConfiguration.class)
public @interface EnableWorkwx {
}
