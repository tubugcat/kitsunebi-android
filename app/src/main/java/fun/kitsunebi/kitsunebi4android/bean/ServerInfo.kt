package `fun`.kitsunebi.kitsunebi4android.bean

import android.provider.Telephony

data class ServerInfo(
        val addrList : Array<Telephony.Mms.Addr>,
        val ver : Int

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ServerInfo

        if (!addrList.contentEquals(other.addrList)) return false
        if (ver != other.ver) return false

        return true
    }

    override fun hashCode(): Int {
        var result = addrList.contentHashCode()
        result = 31 * result + ver
        return result
    }
}