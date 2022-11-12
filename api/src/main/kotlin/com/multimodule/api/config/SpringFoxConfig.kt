package com.multimodule.api.config

import com.fasterxml.classmate.TypeResolver
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.Pageable
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.schema.AlternateTypeRules
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider
import springfox.documentation.spring.web.readers.operation.HandlerMethodResolver
import java.util.*
import javax.servlet.ServletContext


@Configuration
class SpringFoxConfig(
    private val typeResolver: TypeResolver,
) {
    @Bean
    fun api(): Docket {
        val newRule = AlternateTypeRules.newRule(
            typeResolver.resolve(Pageable::class.java),
            typeResolver.resolve(Page::class.java)
        )

        return Docket(DocumentationType.SWAGGER_2)
            .alternateTypeRules(newRule)
            .select()
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo())
    }

    fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
            .title("Service API")
            .description("API Documentation")
            .version("1.0.0")
            .build()
    }


    /**
     * springboot 2.6 이상 업데이트시 springfox 오류 :
     * 2.6부터 ControllerHandler에 매칭시키기 위한 spring.mvc.pathmatch.matching-strategy 기본 값이
     * ant_path_matcher 에서 path_pattern_parser 로 변경.
     *
     * 해결방법 :
     * 1. spring.mvc.pathmatch.matching-strategy: ant_path_matcher 로 변경
     * 2. webMvcRequestHandlerProvider Bean을 재정의 할수있도록
     *    allow-bean-definition-overriding: true 설정 추가한다(default: false)
     * 3. 아래 추가
     *
     * (springdoc으로 변경고려 https://springdoc.org/migrating-from-springfox.html)
     * @see <a href="https://github.com/springfox/springfox/issues/3462"/>
     */
    @Bean
    fun webMvcRequestHandlerProvider(
        context: Optional<ServletContext>,
        methodResolver: HandlerMethodResolver,
        handlerMappings: List<RequestMappingInfoHandlerMapping>
    ): WebMvcRequestHandlerProvider {
        val newHandlerMappings = handlerMappings.filter {
            it.javaClass.name.contains("RequestMapping")
        }
        return WebMvcRequestHandlerProvider(context, methodResolver, newHandlerMappings)
    }

    @ApiModel(description = "페이지 요청")
    data class Page(
        @ApiModelProperty(value = "페이지 번호", example = "0")
        val page: Int,

        @ApiModelProperty(value = "\${sfn.swagger.size.value}", example = "50")
        val size: Int,

        @ApiModelProperty(value = "정렬 (사용법: 컬럼명,ASC|DESC) ex> id,DESC", example = "id,DESC")
        val sort: List<String>,
    )
}
