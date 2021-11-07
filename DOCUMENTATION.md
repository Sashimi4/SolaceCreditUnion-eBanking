# SolaceCreditUnion-eBanking
## Solo Java project for a E-Banking program to display Delegation for Module 226a.

This Project covers the Module 226a and Java skills.

### Objective

Our mission was to come up with a project idea which fulfills some key criterias. For one we should be able to display our competence with Java and different frameworks. Secondly our code should contain some kind of functionality and delegation. It is also preferred to have aggregation and composition.


### My idea

As for my projec idea, it too some time coming up with a project that covers all criterias. But for me the most important thing was that I could work on something which in hindsight would improve my knowledge regarding Java, but also especially project planning with diagrams and sketches. I didn't create much diagram in my Java history before hand. But wit this project I gained a new strength which I will continue to improve on and implement it in my regular life at work.

As I was searching for ideas I discovered a framework which sounded quite intriguing. It promised the ability to create frontend websites and app layouts with pure Java. This was interesting because for one I wouldn't have to work with outdated Java Swing or struggle with JavaFX. For seconds I would still focus on the modules content. **Java**. 

The framework I have been mentioning is called [Vaadin](https://vaadin.com/docs/v14/guide/introduction) and connects with oher well-known frameworks. Such as Spring boot, which I would also be using in my project. As for the actual application I decided to go with an online E-Banking system which would allow the user to complete the following tasks:

__Functions that must be fulfilled:__

- Authentication (_User & Password_)
- Add users with email and person details (_country, address_)
- Open an account containing money amount, currency type etc.
- Add credit cards with amount, codes & numbers
- see statements for when money leaves a card and enters an account and vice-versa. It's main purpose is a type of logging which is readable for the user
- Transfer money from card to account and account to card. Then save information for an individual statements.

The project structure revolves around a Vaadin Java only based fronend. Following that comes a Spring boot business layer for processing data and user information. That processng layer connects through Repostories over Docker, which is a container manager app which allows the creation of databases on a linux kernel on my windows laptop. Docker then manages a PostgreSQL database running on a localhost.


Sadly I can say now from Hindsight, that not al functions were able to be implemented due to lack of panning and time pressure. Never the less I am still proud of the outcome and can't wait to continue working on this, because I sense a big potential out of this small project.

This Github repository contains all classes with bests, build and dependency files. 
As for documentation there are individual screenshots scattere around the documentation folder such as first mock-up ideas, version control and end results. For diagrams there is a draw.io file available containing all diagrams. Sequence, Class, ERD/ERM and use cases. Hopefuly that should give a good insight of how the application was imagined.

This Github also contains a projec tab with Github issues. It dislays all relevant topics with real time signatures such as due dates, creation date and every edit I ever made to the individual cards.


### Reflexion

I learned alot during this project. Firstly with how important planning is. I spent quite a lot of time trying to just find idea instead of taking one more quickly, that might of been maybe easier but which the extra time could'e gotten upgraded to an improved state.
My idea might of been a bit far fetched or out of bounds, but only by reaching limits and comng across challenges can we really evolve and or improve.
Secondly it was quite fun working with big frameworks like Spring boot, which I only had a small history with in the past. I got to implement a security layer and combine frontend with a strong backend. That backend then connected through Docker into a PostgreSQL database.

