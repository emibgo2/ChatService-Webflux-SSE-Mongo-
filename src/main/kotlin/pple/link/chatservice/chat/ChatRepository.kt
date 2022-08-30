package pple.link.chatservice.chat

import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.mongodb.repository.Tailable
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux


@Repository
interface ChatRepository : ReactiveMongoRepository<Chat, String> {
    @Tailable
    fun findBySenderAndReceiver(sender: String,receiver: String):Flux<Chat>

    @Tailable
    fun findByRoomNum(roomNum:Number) :Flux<Chat>
}