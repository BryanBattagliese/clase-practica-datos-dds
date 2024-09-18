package ar.edu.utn.frba.dds.ejercicio_02.personajes;

import ar.edu.utn.frba.dds.ejercicio_02.elementos.ElementoDefensor;
import ar.edu.utn.frba.dds.ejercicio_02.elementos.ElementoDefensorConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "personajes ")
@DiscriminatorColumn(name = "tipoPersonaje")
public abstract class Personaje {

  @Id
  @GeneratedValue
  private Long id;

  @Getter
  @ElementCollection
  @CollectionTable(name = "elementoDefensor")
  @Convert(converter = ElementoDefensorConverter.class)
  @Column(name = "elemento")
  private List<ElementoDefensor> elementos;

  @Getter @Setter
  @Column(name = "estamina")
  private Integer estamina;

  @Getter @Setter
  @Column(name = "puntosDeVida")
  private Integer puntosDeVida;

  public Personaje(){
    this.elementos = new ArrayList<>();
  }

  public void atacar(Personaje personaje) {
  //todo
  }

  public void agregarElemento(ElementoDefensor elemento){
    this.elementos.add(elemento);
  }

}
