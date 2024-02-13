package no.nav.etterlatte.libs.common.innsendtsoeknad

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonValue
import no.nav.etterlatte.libs.common.innsendtsoeknad.common.BetingetOpplysning
import no.nav.etterlatte.libs.common.innsendtsoeknad.common.DatoSvar
import no.nav.etterlatte.libs.common.innsendtsoeknad.common.EnumSvar
import no.nav.etterlatte.libs.common.innsendtsoeknad.common.FritekstSvar
import no.nav.etterlatte.libs.common.innsendtsoeknad.common.JaNeiVetIkke
import no.nav.etterlatte.libs.common.innsendtsoeknad.common.Opplysning

data class Utenlandsadresse(
    val land: Opplysning<FritekstSvar>,
    val adresse: Opplysning<FritekstSvar>? = null
)

data class OppholdUtlandInformasjon(
    val oppholdLand: Opplysning<FritekstSvar>,
    val oppholdFra: Opplysning<DatoSvar>? = null,
    val oppholdTil: Opplysning<DatoSvar>? = null,
)

data class UtbetalingsInformasjon(
    val kontonummer: Opplysning<FritekstSvar>? = null,
    val utenlandskBankNavn: Opplysning<FritekstSvar>? = null,
    val utenlandskBankAdresse: Opplysning<FritekstSvar>? = null,
    val iban: Opplysning<FritekstSvar>? = null,
    val swift: Opplysning<FritekstSvar>? = null,
    val skattetrekk: BetingetOpplysning<EnumSvar<JaNeiVetIkke>, Opplysning<FritekstSvar>?>? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Kontaktinfo(
    val telefonnummer: Opplysning<FritekstSvar>
)

enum class Spraak(@get:JsonValue val verdi: String) { NB("nb"), NN("nn"), EN("en") }
enum class BankkontoType { NORSK, UTENLANDSK }
enum class InntektType { ARBEIDSINNTEKT, PENSJON, KAPITALINNTEKT, ANDRE_YTELSER }
enum class ForholdTilAvdoedeType { GIFT, SEPARERT, SAMBOER, SKILT, TIDLIGERE_SAMBOER }
enum class OppholdUtlandType { BODD, ARBEIDET }
enum class JobbStatusType { ARBEIDSTAKER, SELVSTENDIG, UNDER_UTDANNING, ARBEIDSSOEKER, INGEN }

enum class JobbStatusTypeOMS { ARBEIDSTAKER, SELVSTENDIG, ETABLERER, TILBUD, UNDER_UTDANNING, ARBEIDSSOEKER, INGEN }
enum class IngenJobb {
    HJEMMEARBEIDENDE,
    OMSORG_BARN,
    OMSORG_NAERSTAAENDE,
    FRIVILLIG_ARBEID,
    ETABLERER_BEDRIFT,
    SYK,
    ANNET
}

enum class SagtOppEllerRedusertType { OPPSAGT, REDUSERT, NEI }

enum class StudieformType { HELTID, DELTID }

enum class StillingType { FAST, MIDLERTIDIG, SESONGARBEID, TILKALLINGSVIKAR }
enum class OmsorgspersonType { GJENLEVENDE, VERGE, ANNET }
enum class SivilstatusType { ENKE, ENSLIG, EKTESKAP, SAMBOERSKAP }

enum class EndringAvInntektGrunnType {
    OEKT_STILLINGSPROSENT,
    REDUSERT_STILLINGSPROSENT,
    PERMISJON_UTEN_LOENN,
    LOENNSOEKNING,
    ARBEIDSLEDIG,
    SESONGARBEID,
    BYTTE_AV_JOBB,
    ANNEN_GRUNN
}

enum class PensjonEllerTrygdType { TJENESTEPENSJONSORDNING, UFOEREPENSJON_FRA_NAV, ALDERSPENSJON_FRA_NAV }

enum class PensjonsYtelseType {
    AVTALEFESTET_PENSJON_OFFENTLIG,
    AVTALEFESTET_PENSJON_PRIVAT,
    SAERALDERSPENSJON,
    UFOEREPENSJON,
    ALDERSPENSJON
}

enum class InntektEllerUtbetalingType {
    DAGSPENGER,
    SYKEPENGER,
    PLEIEPENGER,
    SVANGERSKAPSPENGER,
    FORELDREPENGER,
    ARBEIDSAVKLARINGSPENGER,
    KVALIFISERINGSSTOENAD,
    KOMMUNAL_OMSORGSSTOENAD,
    FOSTERHJEMSGODTGJOERING,
    OMSORGSPENGER,
    OPPLAERINGSPENGER,
}

enum class SoekbareYtelserNAVType {
    DAGSPENGER,
    SYKEPENGER,
    PLEIEPENGER,
    SVANGERSKAPSPENGER,
    FORELDREPENGER,
    ARBEIDSAVKLARINGSPENGER,
    KVALIFISERINGSSTOENAD,
    KOMMUNAL_OMSORGSSTOENAD,
    FOSTERHJEMSGODTGJOERING,
    OMSORGSPENGER,
    OPPLAERINGSPENGER,
    UFOEREPENSJON,
    ALDERSPENSJON
}

enum class SoekbareYtelserAndreType {
    AVTALEFESTET_PENSJON_OFFENTLIG,
    AVTALEFESTET_PENSJON_PRIVAT,
    SAERALDERSPENSJON,
    UFOEREPENSJON,
    ALDERSPENSJON
}

enum class NorgeEllerUtlandType { NORGE, UTLAND }

data class SamboerInntekt(
    val inntektstype: Opplysning<List<EnumSvar<InntektType>>>,
    val samletBruttoinntektPrAar: Opplysning<FritekstSvar>,
)

data class ForholdTilAvdoede(
    val relasjon: Opplysning<EnumSvar<ForholdTilAvdoedeType>>,
    val datoForInngaattPartnerskap: Opplysning<DatoSvar>? = null,
    val datoForInngaattSamboerskap: Opplysning<DatoSvar>? = null,
    val datoForSkilsmisse: Opplysning<DatoSvar>? = null,
    val datoForSamlivsbrudd: Opplysning<DatoSvar>? = null,
    val fellesBarn: Opplysning<EnumSvar<JaNeiVetIkke>>?,
    val samboereMedFellesBarnFoerGiftemaal: Opplysning<EnumSvar<JaNeiVetIkke>>? = null,
    val tidligereGift: Opplysning<EnumSvar<JaNeiVetIkke>>? = null,
    val omsorgForBarn: Opplysning<EnumSvar<JaNeiVetIkke>>? = null,
    val mottokBidrag: BetingetOpplysning<EnumSvar<JaNeiVetIkke>, Opplysning<FritekstSvar>?>? = null, // Finner ikke igjen
    val mottokEktefelleBidrag: Opplysning<EnumSvar<JaNeiVetIkke>>? = null, // Finner ikke igjen?
)

data class ForholdTilAvdoedeOMS(
    val relasjon: Opplysning<EnumSvar<ForholdTilAvdoedeType>>,
    val datoForInngaattPartnerskap: Opplysning<DatoSvar>? = null,
    val datoForInngaattSamboerskap: Opplysning<DatoSvar>? = null,
    val datoForSkilsmisse: Opplysning<DatoSvar>? = null,
    val datoForSamlivsbrudd: Opplysning<DatoSvar>? = null,
    val fellesBarn: Opplysning<EnumSvar<JaNeiVetIkke>>?,
    val samboereMedFellesBarnFoerGiftemaal: Opplysning<EnumSvar<JaNeiVetIkke>>? = null,
    val tidligereGift: Opplysning<EnumSvar<JaNeiVetIkke>>? = null,
    val mottokBidrag: BetingetOpplysning<EnumSvar<JaNeiVetIkke>, Opplysning<FritekstSvar>?>? = null,
)

data class Utenlandsopphold(
    val land: Opplysning<FritekstSvar>,
    val fraDato: Opplysning<DatoSvar>?,
    val tilDato: Opplysning<DatoSvar>?,
    val oppholdsType: Opplysning<List<EnumSvar<OppholdUtlandType>>>,
    val medlemFolketrygd: Opplysning<EnumSvar<JaNeiVetIkke>>,
    val pensjonsutbetaling: Opplysning<FritekstSvar>?
)

data class Naeringsinntekt(
    val naeringsinntektPrAarFoerDoedsfall: Opplysning<FritekstSvar>?,
    val naeringsinntektVedDoedsfall: Opplysning<EnumSvar<JaNeiVetIkke>>?
)

typealias AarstallForMilitaerTjeneste = FritekstSvar

data class ArbeidOgUtdanning(
    val dinSituasjon: Opplysning<List<EnumSvar<JobbStatusType>>>,
    val arbeidsforhold: Opplysning<List<Arbeidstaker>>?,
    val selvstendig: Opplysning<List<SelvstendigNaeringsdrivende>>?,
    val utdanning: Opplysning<Utdanning>?,
    val annet: Opplysning<EnumSvar<IngenJobb>>?,
)

data class ArbeidOgUtdanningOMS(
    val dinSituasjon: Opplysning<List<EnumSvar<JobbStatusTypeOMS>>>,
    val arbeidsforhold: Opplysning<List<ArbeidstakerOMS>>?,
    val selvstendig: Opplysning<List<SelvstendigNaeringsdrivendeOMS>>?,
    val etablererVirksomhet: Opplysning<EtablererVirksomhet>?,
    val tilbud: Opplysning<TilbudOmJobb>?,
    val arbeidssoeker: Opplysning<Arbeidssoeker>?,
    val utdanning: Opplysning<UtdanningOMS>?,
    val annenSituasjon: Opplysning<AnnenSituasjon>?,
)

data class Utdanning(
    val navn: Opplysning<FritekstSvar>,
    val startDato: Opplysning<DatoSvar>,
    val sluttDato: Opplysning<DatoSvar>,
)

data class UtdanningOMS(
    val startDato: Opplysning<DatoSvar>,
    val sluttDato: Opplysning<DatoSvar>,
    val studiested: Opplysning<FritekstSvar>,
    val studie: Opplysning<FritekstSvar>,
    val studieform: Opplysning<EnumSvar<StudieformType>>,
    val studieprosent: Opplysning<FritekstSvar>?,
    val godkjentUtdanning: Opplysning<EnumSvar<JaNeiVetIkke>>
)

typealias AnnenUtdanning = FritekstSvar

enum class HoeyesteUtdanning {
    GRUNNSKOLE,
    VIDEREGAAENDE,
    FAGBREV,
    UNIVERSITET_OPPTIL_4_AAR,
    UNIVERSITET_OVER_4_AAR,
    INGEN,
    ANNEN
}

typealias EndretInntektBegrunnelse = FritekstSvar

data class SelvstendigNaeringsdrivende(
    val firmanavn: Opplysning<FritekstSvar>,
    val orgnr: Opplysning<FritekstSvar>,
    val endretInntekt: BetingetOpplysning<EnumSvar<JaNeiVetIkke>, Opplysning<EndretInntektBegrunnelse>>,
)

data class SelvstendigNaeringsdrivendeOMS(
    val firmanavn: Opplysning<FritekstSvar>,
    val orgnr: Opplysning<FritekstSvar>,
    val arbeidsmengde: Opplysning<FritekstSvar>,
    val endretArbeidssituasjon: BetingetOpplysning<EnumSvar<JaNeiVetIkke>, Opplysning<EndretInntektBegrunnelse>?>
)

data class Arbeidstaker(
    val arbeidsgiver: Opplysning<FritekstSvar>,
    val ansettelsesforhold: Opplysning<EnumSvar<StillingType>>,
    val stillingsprosent: Opplysning<FritekstSvar>,
    val endretInntekt: BetingetOpplysning<EnumSvar<JaNeiVetIkke>, Opplysning<EndretInntektBegrunnelse>>
)

data class ArbeidstakerOMS(
    val arbeidsgiver: Opplysning<FritekstSvar>,
    val ansettelsesforhold: Opplysning<EnumSvar<StillingType>>,
    val arbeidsmengde: Opplysning<FritekstSvar>,
    val harSluttDato: Opplysning<EnumSvar<JaNeiVetIkke>>?,
    val sluttDato: Opplysning<DatoSvar>?,
    val endretArbeidssituasjon: BetingetOpplysning<EnumSvar<JaNeiVetIkke>, Opplysning<EndretInntektBegrunnelse>?>,
    val sagtOppEllerRedusert: Opplysning<EnumSvar<SagtOppEllerRedusertType>>? = null, // Venter på avklaring om den skal fjernes
)

data class EtablererVirksomhet(
    val virksomheten: Opplysning<FritekstSvar>,
    val orgnr: Opplysning<FritekstSvar>,
    val forretningsplan: Opplysning<EnumSvar<JaNeiVetIkke>>,
    val samarbeidMedNav: Opplysning<EnumSvar<JaNeiVetIkke>>?
)

data class TilbudOmJobb(
    val nyttArbeidssted: Opplysning<FritekstSvar>,
    val ansettelsesdato: Opplysning<DatoSvar>,
    val ansettelsesforhold: Opplysning<EnumSvar<StillingType>>,
    val arbeidsmengde: Opplysning<FritekstSvar>,
    val harSluttdato: Opplysning<EnumSvar<JaNeiVetIkke>>?,
    val sluttdato: Opplysning<DatoSvar>?
)

data class Arbeidssoeker(
    val registrertArbeidssoeker: Opplysning<EnumSvar<JaNeiVetIkke>>,
    val aktivitetsplan: Opplysning<EnumSvar<JaNeiVetIkke>>?
)

data class AnnenSituasjon(
    val beskrivelse: Opplysning<EnumSvar<IngenJobb>>,
    val annet: Opplysning<FritekstSvar>?
)

data class InntektOgPensjon(
    val loennsinntekt: Opplysning<Loennsinntekt>?,
    val naeringsinntekt: Opplysning<Loennsinntekt>?,
    val pensjonEllerUfoere: PensjonEllerUfoere?,
    val inntektViaYtelserFraNAV: InntektViaYtelserFraNAV?,
    val ingenInntekt: IngenInntekt?,
    val ytelserNAV: YtelserNav,
    val ytelserAndre: YtelserAndre,
)

data class Loennsinntekt(
    val norgeEllerUtland: Opplysning<List<EnumSvar<NorgeEllerUtlandType>>>,
    val norge: InntektSamlet?,
    val utland: InntektSamlet?,
    val endringAvInntekt: EndringAvInntekt
)

data class InntektSamlet(
    val inntektAaretFoerDoedsfall: Opplysning<FritekstSvar>?,
    val inntektIFjor: TilDoedsfallOgAarsinntekt?,
    val inntektIAar: TilDoedsfallOgAarsinntekt?,
    val inntektNesteAar: Aarsinntekt?,
    val jevntOpptjentNaeringsinntekt: JevntOpptjentNaeringsinntekt?
)

data class TilDoedsfallOgAarsinntekt(
    val tilDoedsfall: Opplysning<FritekstSvar>?,
    val aarsinntekt: Opplysning<FritekstSvar>?
)

data class Aarsinntekt(
    val aarsinntekt: Opplysning<FritekstSvar>?
)

data class JevntOpptjentNaeringsinntekt(
    val svar: Opplysning<EnumSvar<JaNeiVetIkke>>,
    val beskrivelse: Opplysning<FritekstSvar>?
)

data class EndringAvInntekt(
    val fremtidigEndringAvInntekt: Opplysning<EnumSvar<JaNeiVetIkke>>,
    val grunn: Opplysning<EnumSvar<EndringAvInntektGrunnType>>?,
    val annenGrunn: Opplysning<FritekstSvar>?
)

data class PensjonEllerUfoere(
    val pensjonstype: Opplysning<List<EnumSvar<PensjonEllerTrygdType>>>,
    val tjenestepensjonsordning: Tjenestepensjonsordning?,
    val utland: Utland
)

data class Tjenestepensjonsordning(
    val type: Opplysning<EnumSvar<PensjonsYtelseType>>,
    val utbetaler: Opplysning<FritekstSvar>
)

data class Utland(
    val svar: Opplysning<EnumSvar<JaNeiVetIkke>>,
    val type: Opplysning<FritekstSvar>?,
    val land: Opplysning<FritekstSvar>?,
    val beloepMedValuta: Opplysning<FritekstSvar>?
)

data class InntektViaYtelserFraNAV(
    val ytelser: Opplysning<List<EnumSvar<InntektEllerUtbetalingType>>>
)
data class IngenInntekt(
    val svar: Opplysning<JaNeiVetIkke>,
    val beloep: Opplysning<FritekstSvar>?,
    val beskrivelse: Opplysning<FritekstSvar>?,
)

data class YtelserNav(
    val soektOmYtelse: Opplysning<EnumSvar<JaNeiVetIkke>>,
    val soektYtelse: Opplysning<List<EnumSvar<SoekbareYtelserNAVType>>>?
)

data class YtelserAndre(
    val soektOmYtelse: Opplysning<EnumSvar<JaNeiVetIkke>>,
    val soektYtelse: Opplysning<List<EnumSvar<SoekbareYtelserAndreType>>>?,
    val pensjonsordning: Opplysning<FritekstSvar>?,
)

enum class Ytelser {
    DAGPENGER,
    SYKEPENGER,
    PLEIEPENGER,
    SVANGERSKAPSPENGER,
    FORELDREPENGER,
    ARBEIDSAVKLARINGSPENGER,
    KVALIFISERINGSSTOENAD,
    KOMMUNAL_OMSORGSSTONAD,
    FOSTERHJEMSGODTGJOERING,
    OMSORGSPENGER,
    OPPLAERINGSPENGER
}

enum class Stoenader {
    BARNETILSYN,
    SKOLEPENGER,
    TILLEGGSSTOENAD_BARNEPASS,
    TILLEGGSSTOENAD_UTDANNING
}

typealias Pensjonsordning = FritekstSvar

data class AndreYtelser(
    val kravOmAnnenStonad: BetingetOpplysning<EnumSvar<JaNeiVetIkke>, Opplysning<EnumSvar<Ytelser>>?>,
    val annenPensjon: BetingetOpplysning<EnumSvar<JaNeiVetIkke>, Opplysning<Pensjonsordning>?>,
    val pensjonUtland: BetingetOpplysning<EnumSvar<JaNeiVetIkke>, PensjonUtland?>
)

data class PensjonUtland(
    val pensjonsType: Opplysning<FritekstSvar>?,
    val land: Opplysning<FritekstSvar>?,
    val bruttobeloepPrAar: Opplysning<FritekstSvar>?,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class OppholdUtland(
    val land: Opplysning<FritekstSvar>? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class OppholdUtlandOMS(
    val bosattLand: Opplysning<FritekstSvar>? = null,
    val oppholderSegIUtlandet: Opplysning<EnumSvar<JaNeiVetIkke>>? = null,
    val oppholdsland: Opplysning<FritekstSvar>? = null,
    val oppholdFra: Opplysning<DatoSvar>? = null,
    val oppholdTil: Opplysning<DatoSvar>? = null,
)
