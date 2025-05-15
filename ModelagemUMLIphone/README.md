# Desafio POO - iPhone

Este projeto representa a modelagem UML do iPhone, com foco em suas funcionalidades como Reprodutor Musical, Aparelho Telefônico e Navegador de Internet, conforme desafio proposto na plataforma DIO.

## Diagrama UML

### Versão Visual

![Diagrama UML do iPhone](images/diagrama-iphone.png)

### Código Mermaid
```mermaid
classDiagram
    class iPhone {
        -boolean ligado
        +iPhone()
        +ligar()
        +desligar()
        +reiniciar()
    }
    
    class ReprodutorMusical {
        <<interface>>
        +tocar()
        +pausar()
        +selecionarMusica(String musica)
    }
    
    class AparelhoTelefonico {
        <<interface>>
        +ligar(String numero)
        +atender()
        +iniciarCorreioVoz()
    }
    
    class NavegadorInternet {
        <<interface>>
        +exibirPagina(String url)
        +adicionarNovaAba()
        +atualizarPagina()
    }
    
    iPhone ..|> ReprodutorMusical : implements
    iPhone ..|> AparelhoTelefonico : implements
    iPhone ..|> NavegadorInternet : implements
```
