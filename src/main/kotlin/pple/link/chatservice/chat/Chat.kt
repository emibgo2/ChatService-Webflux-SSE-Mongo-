package pple.link.chatservice.chat

import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Document
class Chat (sender:String,receiver:String,msg:String) {
    @Id
    var id: String?=null
    var msg: String = "msg"
    var sender:String = "sender"
    var receiver:String = "receiver"
    var createdAt:LocalDateTime = LocalDateTime.now()
    var roomNum: Number? = null

    init {
        this.msg = msg
        this.sender = sender
        this.receiver = receiver
    }

}