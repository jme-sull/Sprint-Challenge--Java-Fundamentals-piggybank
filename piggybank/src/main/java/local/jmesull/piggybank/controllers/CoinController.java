package local.jmesull.piggybank.controllers;

import local.jmesull.piggybank.models.Coin;
import local.jmesull.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController
{
    @Autowired
    CoinRepository coinrepo;

    //http://localhost:2019/total
    @GetMapping(value = "/total",
    produces = {"application/json"})
    public ResponseEntity<?> listTotalCoins()
    {
        List<Coin> myList = new ArrayList<>();
        coinrepo.findAll().iterator().forEachRemaining(myList::add);

        double total = 0;

        for(Coin c : myList)
        {
            total = total + (c.getQuantity() * c.getValue());
        }

        for(Coin c: myList)
        {
            if (c.getQuantity() > 1 || c.getQuantity() == 0)
            {
                System.out.println(c.getQuantity() + " " + c.getNamepural());
            }

            if (c.getQuantity() == 1)
            {
                System.out.println(c.getQuantity() + " " + c.getName());
            }

        }

        System.out.println("The piggy bank holds " + total);


        return new ResponseEntity<>(HttpStatus.OK);
    }
}
