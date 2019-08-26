package `fun`.kitsunebi.kitsunebi4android.bean

import android.provider.Telephony

data class ServerInfo(
        val addrList : Array<Telephony.Mms.Addr>
        val ver : Int
        
)