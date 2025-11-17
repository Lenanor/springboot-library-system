# Individuell Repetitionsuppgift – Library
API
I denna uppgift ska du individuellt skapa ett litet bibliotekssystem som REST-API med
Spring Boot.
Du ska själv konstruera modeller, relationer och logik baserat på kraven nedan.
Syftet är att du ska visa att du förstår databaskoppling, JPA-relationer, DTO:er,
validering, service-lager, JPQL-querys och felhantering.

## Del 1 – Modellering (JPA & Relationer)
**Du ska själv designa följande delar:**
- Systemet ska hantera användare, böcker och lån.
- Du ska definiera minst tre entiteter som representerar dessa delar.
- Det ska finnas relationer mellan entiteterna, inklusive:
  - att en användare kan låna flera böcker
  - att en bok kan lånas flera gånger
  - ett lån ska innehålla extra information (exempelvis lånedatum)

Du bestämmer själv vilka relationstyper som ska användas (OneToMany, ManyToOne, etc.)
— men de ska vara korrekta och motiverade.

**Tekniska krav:**
- Använd @Entity, @Id, @GeneratedValue.
- Använd cascade där det är motiverat.
- Du ska själv avgöra vilka fält varje entitet behöver.

## Del 2 – DTO & Validering
Du ska skapa DTO-klasser (minst två) som används i POST-anrop.
**Krav:**
- DTO:er ska innehålla valideringsregler med annoteringar som:
  - @NotBlank
  - @Size
  - @Email
  - @Min, @Max
  - Controller ska använda @Valid.
  - Du bestämmer själv vilka fält som behöver validering.
  
## Del 3 – Controllers & Endpoints
Du ska skapa minst följande endpoints:
1. POST för att skapa en användare
   - Tar en DTO.
   - Valideras.  


2. POST för att lägga till en bok
   - Tar en DTO.
   - Valideras.


3. POST för att registrera ett lån
   - Tar emot användar-id och bok-id.
   - Intern logik ska kontrollera att boken går att låna (du definierar reglerna).
   - Lånet ska automatiskt sättas med dagens datum.

    
4. Endpoint för att markera att en bok lämnas tillbaka


5. Endpoint för att visa alla böcker en användare har lånat


6. Endpoint för att visa alla aktiva lån
   Du bestämmer själv endpoint-namn och hur datan presenteras.

## Del 4 – Service-lager (affärslogik)
All logik ska ligga i service-klasser.

**Krav:**
- Kontrollera att objekt finns (annars kasta exception).
- Hantera logik för att låna ut och återlämna böcker.
- Hindra otillåtna situationer (du definierar vilka).
- Dela inte upp logiken i controllern.
- Service-lagret ska använda repository-lagret för databasaccess.


## Del 5 – Felhantering
Skapa en global felhanterare med @RestControllerAdvice.

**Krav:**
Den ska hantera minst
- Valideringsfel (MethodArgumentNotValidException) → 400
- Saknade resurser (EntityNotFoundException) → 404
- Logiska fel (IllegalStateException) → 409

Fel ska skickas tillbaka som tydlig JSON.

## Del 6 – Repository-lager & JPQL
Du ska skapa egna anpassade JPQL-querys i repository-lagret.

**Krav:**
- Minst tre egna JPQL-querys.
- De ska använda @Query och @Param.
- Standard JPA-metoder räcker inte — du ska skapa egna.

**Förslag på typer av frågor (du väljer själv vilka du implementerar):**

**I ett bok-repository:**
- Hämta alla böcker av en viss författare.
- Hämta böcker äldre än ett visst år.

**I ett användar-repository:**
- Hämta alla användare vars namn matchar en text (case-insensitive).
- Räkna hur många lån en användare har haft totalt.

**I ett lån-repository:**
- Hämta alla aktiva lån (t.ex. returnDate = null).
- Hämta alla lån efter ett visst datum.