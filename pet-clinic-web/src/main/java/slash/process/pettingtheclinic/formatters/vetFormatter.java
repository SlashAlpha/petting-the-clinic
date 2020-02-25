package slash.process.pettingtheclinic.formatters;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import slash.process.pettingtheclinic.model.Vet;
import slash.process.pettingtheclinic.services.VetService;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class vetFormatter implements Formatter<Vet> {

    VetService vetService;

    public vetFormatter(VetService vetService) {
        this.vetService = vetService;
    }

    @Override
    public String print(Vet vet, Locale locale) {
        return vet.getLastName();
    }

    @Override
    public Vet parse(String text, Locale locale) throws ParseException {
        Collection<Vet> findVet = vetService.findAll();
        for (Vet type : findVet) {
            if (type.getLastName().equals(text)) {
                return type;
            }
        }
        throw new ParseException("type not found: " + text, 0);
    }
}
