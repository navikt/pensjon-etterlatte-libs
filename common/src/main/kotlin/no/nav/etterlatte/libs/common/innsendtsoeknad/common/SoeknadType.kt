package no.nav.etterlatte.libs.common.innsendtsoeknad.common

enum class SoeknadType(val behandlingstema: String) {
    GJENLEVENDEPENSJON("ab0011"),
    BARNEPENSJON("ab0255"),
    OMSTILLINGSSTOENAD("oms_behandlingstema_placeholder")
}


fun finnBehandlingsnummerFromSaktype(saktype: SoeknadType): Behandlingsnummer {
    return when (saktype) {
        SoeknadType.GJENLEVENDEPENSJON -> Behandlingsnummer.GJENLEVENDEPENSJON
        SoeknadType.BARNEPENSJON -> Behandlingsnummer.BARNEPENSJON
        SoeknadType.OMSTILLINGSSTOENAD -> Behandlingsnummer.OMSTILLINGSSTOENAD
    }
}

enum class Behandlingsnummer(val behandlingsnummer: String) {
    BARNEPENSJON("B359"),
    OMSTILLINGSSTOENAD("B373"),
    GJENLEVENDEPENSJON("B222"),
}
