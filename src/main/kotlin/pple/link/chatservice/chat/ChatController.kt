package pple.link.chatservice.chat

import lombok.RequiredArgsConstructor
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import java.awt.PageAttributes


@RestController
class ChatController(private val repo: ChatRepository) {

    @CrossOrigin
    @GetMapping(value = ["/sender/{sender}/receiver/{receiver}"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getMsg(@PathVariable receiver: String, @PathVariable sender: String): Flux<Chat> {
        return repo.findBySenderAndReceiver(sender,receiver)
            .subscribeOn(Schedulers.boundedElastic())
    }


    @CrossOrigin
    @PostMapping("/chat")
    fun setMsg(@RequestBody chat: ChatData): Mono<Chat> {
        return repo.save(Chat(sender = chat.sender, receiver = chat.receiver, msg = chat.msg))
    }
}