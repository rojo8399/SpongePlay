package org.spongepowered.play

import com.google.inject.AbstractModule
import org.spongepowered.play.mail.{Mailer, MailerImpl}

class SpongeModule extends AbstractModule {

  def configure() = {
    bind(classOf[Mailer]).to(classOf[MailerImpl])
  }

}
