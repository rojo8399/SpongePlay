package org.spongepowered.play

import com.google.inject.AbstractModule
import org.spongepowered.play.mail.{Mailer, SpongeMailer}
import org.spongepowered.play.security.{SingleSignOnConsumer, SpongeSingleSignOnConsumer}

/**
  * The base Sponge Play module.
  */
class SpongeModule extends AbstractModule {

  def configure() = {
    bind(classOf[Mailer]).to(classOf[SpongeMailer])
    bind(classOf[SingleSignOnConsumer]).to(classOf[SpongeSingleSignOnConsumer])
  }

}
