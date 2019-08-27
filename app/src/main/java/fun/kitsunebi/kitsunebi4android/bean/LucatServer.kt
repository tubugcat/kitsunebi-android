package `fun`.kitsunebi.kitsunebi4android.bean

data class LucatServer(
    val detail :String,
    val fromUrl : String,
    val imageUrls : Array<String>

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LucatServer

        if (detail != other.detail) return false
        if (fromUrl != other.fromUrl) return false
        if (!imageUrls.contentEquals(other.imageUrls)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = detail.hashCode()
        result = 31 * result + fromUrl.hashCode()
        result = 31 * result + imageUrls.contentHashCode()
        return result
    }
}