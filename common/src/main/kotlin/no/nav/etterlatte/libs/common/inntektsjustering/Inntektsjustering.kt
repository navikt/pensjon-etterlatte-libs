package no.nav.etterlatte.libs.common.inntektsjustering

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.Instant
import java.util.UUID

@JsonIgnoreProperties(ignoreUnknown = true)
data class Inntektsjustering(
    val id: UUID,
    val sakId: Long,
    val aar: Int,
    val arbeidsinntekt: Int,
    val naeringsinntekt: Int,
    val arbeidsinntektUtland: Int,
    val naeringsinntektUtland: Int,
    val tidspunkt: Instant,
)