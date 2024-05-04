package features.core.domain.local.model

data class Note(
    val header: String,
    val note: String,
    val creationDate: String,
    val modifyDate: String,
    val id: String? = null
)
