package com.multimodule.domain.support

import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties

class Utils {
    private fun <T: Any> objectToDeepFlatMap(obj: T): Map<String, Any?> {
        val map = mutableMapOf<String, Any?>()
        obj::class.memberProperties.forEach { prop ->
            val value = prop.getter.call(obj)
            if (value != null) {
                if (prop.returnType.classifier is KClass<*>) {
                    val classifier = prop.returnType.classifier as KClass<*>
                    if (classifier.isData) {
                        map.putAll(objectToDeepFlatMap(value))
                    } else {
                        map[prop.name] = value
                    }
                } else {
                    map[prop.name] = value
                }
            } else{
                map[prop.name] = null
            }
        }
        return map
    }
}