package me.park.springbootkotlin.admin.data

import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties

data class TableDTO(
    val name: String,
    val columns: List<String>,
    val records: List<List<String>>
) {
    companion object {
        fun <T : Any> from(classInfo: KClass<T>, entities: List<Any>, vararg filterings: String): TableDTO {
            val name = classInfo.simpleName ?: "Unknown"
            // "*" 은 스프레드 연산자(spread operator) 배열이나 컬렉션을 개별 요소로 풀어서 함수에 전달할 수 있다.
            val columns = createColumns(classInfo, *filterings)
            val records = entities.map { entity ->
                columns.map { column ->
                    classInfo.memberProperties
                        .find { column == it.name }
                        ?.getter
                        ?.call(entity)
                        .toString()
                }.toList()
            }.toList()

            return TableDTO(name = name, columns = columns, records = records)
        }

        private fun <T : Any> createColumns(classInfo: KClass<T>, vararg filterings: String)
                : MutableList<String> {
            val mainColumns = classInfo.java.declaredFields
                .filter { !filterings.contains(it.name) }
                .map { it.name }
                .toMutableList()
            val baseColumns = classInfo.java.superclass.declaredFields
                .map { it.name }
                .toMutableList()

            return (mainColumns + baseColumns).toMutableList()
        }
    }
}
