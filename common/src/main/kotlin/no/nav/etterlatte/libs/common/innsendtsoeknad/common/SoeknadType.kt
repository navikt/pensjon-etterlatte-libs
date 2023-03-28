package no.nav.etterlatte.libs.common.innsendtsoeknad.common

enum class SoeknadType(val behandlingstema: String) {
    GJENLEVENDEPENSJON("ab0011"),
    BARNEPENSJON("ab0255"),
    OMSTILLINGSSTOENAD("oms_behandlingstema_placeholder")
}
