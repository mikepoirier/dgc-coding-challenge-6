package io.mikepoirier.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono

@Configuration
class Routes(val testHandler: TestHandler) {

    @Bean
    fun apiRoutes() = router {
        accept(MediaType.APPLICATION_JSON).nest {
            "/path".nest {
                GET("/", { req -> Mono.empty() })
            }
            "/test".nest {
                GET("/", testHandler::handleGet)
            }
        }
    }
}