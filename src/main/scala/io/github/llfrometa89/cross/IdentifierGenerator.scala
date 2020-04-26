package io.github.llfrometa89.cross

import java.util.UUID

class IdentifierGenerator {
  def generate: String = UUID.randomUUID().toString
}
