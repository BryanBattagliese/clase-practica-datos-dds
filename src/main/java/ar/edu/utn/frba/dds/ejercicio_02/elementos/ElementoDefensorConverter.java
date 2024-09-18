package ar.edu.utn.frba.dds.ejercicio_02.elementos;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ElementoDefensorConverter implements AttributeConverter<ElementoDefensor, String> {

    @Override
    public String convertToDatabaseColumn(ElementoDefensor elementoDefensor) {
        if(elementoDefensor instanceof Escudo){
            return "Escudo";
        } else if (elementoDefensor instanceof Espada) {
            return "Espada";
        }else if (elementoDefensor instanceof Arco) {
            return "Arco";
        }
        return null;
    }

    @Override
    public ElementoDefensor convertToEntityAttribute(String dbData) {
        switch (dbData) {
            case "Espada":
                return new Espada();
            case "Arco":
                return new Arco();
            case "Escudo":
                return new Escudo();
            default:
                throw new IllegalArgumentException("Unknown" + dbData);
        }
    }

    }
