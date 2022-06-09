# pensjon-etterlatte-libs

Felles biblioteker for Team Etterlatte.


# Apper

- [common](common)
- [common-test](common-test)
- [ktor-client-auth](ktor-client-auth)


# Kom i gang

Pakkene som produseres ved release her lagres i Github Package Registry, som krever autentisering. 
For å ta de i bruk som dependencies i et annet prosjekt er det enkleste er å lage et 
[PAT (Personal Access Token)](https://github.com/settings/tokens).

1. [Opprett PAT her](https://github.com/settings/tokens). I tilfelle lenken ikke fungerer går man til `Github -> Settings -> Developer settings -> Personal access tokens`
2. Huk av `read:packages`. Ikke legg til flere scopes enn nødvendig.
3. Tokenet legges i `.zshrc` med `export GITHUB_TOKEN=<token>`


# Felles apper

Alle apper som er felles for Team Etterlatte ligger i [etterlatte-pensjon-felles](https://github.com/navikt/pensjon-etterlatte-felles).


# Kafka / Rapids & Rivers

Topic.yaml-filer er flyttet til [etterlatte-pensjon-felles](https://github.com/navikt/pensjon-etterlatte-felles).


# Bygg og release


En app bygges og deployes automatisk når en endring legges til i `main`.

For å trigge **manuell deploy** kan du gå til `Actions -> (velg workflow) -> Run workflow from <branch>`


# Henvendelser

Spørsmål knyttet til koden eller prosjektet kan stilles som issues her på GitHub.


## For NAV-ansatte

Interne henvendelser kan sendes via Slack i kanalen #po-pensjon-team-etterlatte.
