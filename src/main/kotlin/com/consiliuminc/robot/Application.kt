package com.consiliuminc.robot

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.PropertySource
import org.springframework.context.support.AbstractApplicationContext
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement


@PropertySource(
    value = ["classpath:application.properties", "classpath:persistence.properties", "classpath:application.yml"],
    encoding = "utf-8"
)
@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
class Application : SpringBootServletInitializer() {


    @Bean
    fun commandLineRunner(ctx: ApplicationContext): CommandLineRunner? {
        return CommandLineRunner { args: Array<String> ->
            (ctx as AbstractApplicationContext).registerShutdownHook()
        }
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)

}
