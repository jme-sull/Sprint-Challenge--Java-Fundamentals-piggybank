package local.jmesull.piggybank.controllers;

import local.jmesull.piggybank.models.Coin;
import local.jmesull.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    //http://localhost:2019/money/{amount}

    @GetMapping(value = "/money/{amount}",
    produces = {"application/json"})
    public ResponseEntity<?> removeCoins(@PathVariable double amount)
    {
        List<Coin> myList = new ArrayList<>();
        coinrepo.findAll().iterator().forEachRemaining(myList::add);

        double initalTotal = 0;
        for(Coin c : myList)
        {
            initalTotal = initalTotal + (c.getQuantity() * c.getValue());
        }

        if(amount > initalTotal)
        {
            System.out.println("You don't have enough in the piggy bank!");
        }

        if(amount <= initalTotal)
        {
                int dollars = (int) amount;
                double cents = (amount - dollars) * 100;
                int intCents = (int) cents;

                int dimes = intCents / 10;
                intCents = intCents - (dimes * 10);
                int nickles = intCents / 5;
                intCents = intCents - (nickles * 5);
                int pennies = intCents / 1;

                //subtract the amount
                for(Coin c : myList)
                {
                    if (c.getName().contains("ollar"))
                    {
                        int initalQuantity = c.getQuantity();

                        if (initalQuantity >= dollars)
                        {
                            c.setQuantity(c.getQuantity() - dollars);
                            dollars = 0;
                        }

                        if (initalQuantity < dollars)
                        {
                            c.setQuantity(0);
                            dollars = dollars - initalQuantity;
                        }

                    }

                    if (c.getName().contains("arter"))
                    {
                        int initalQuantity = c.getQuantity();
                        int quarters = intCents / 25;
                        intCents = intCents - (quarters * 25);
                        if (initalQuantity >= quarters)
                        {
                            c.setQuantity(c.getQuantity() - quarters);
                            quarters = 0;
                        }

                        if (initalQuantity < quarters)
                        {
                            c.setQuantity(0);
                            quarters = quarters - initalQuantity;
                        }

                    }

                    if (c.getName().contains("ime"))
                    {
                        int initalQuantity = c.getQuantity();
                        if (initalQuantity >= dimes)
                        {
                            c.setQuantity(c.getQuantity() - dimes);
                            dimes = 0;
                        }

                        if (initalQuantity < dimes)
                        {
                            c.setQuantity(0);
                            dimes = dimes - initalQuantity;
                        }

                    }

                    if (c.getName().contains("ickle"))
                    {
                        int initalQuantity = c.getQuantity();
                        if (initalQuantity >= nickles)
                        {
                            c.setQuantity(c.getQuantity() - nickles);
                            nickles = 0;
                        }

                        if (initalQuantity < nickles)
                        {
                            c.setQuantity(0);
                            nickles = nickles - initalQuantity;
                        }
                    }

                    if (c.getName().contains("ennie"))
                    {
                        int initalQuantity = c.getQuantity();

                        if (initalQuantity >= pennies)
                        {
                            c.setQuantity(c.getQuantity() - pennies);
                            pennies = 0;
                        }

                        if (initalQuantity < pennies)
                        {
                            c.setQuantity(0);
                            pennies = pennies - initalQuantity;
                        }

                }
        }}


        for(Coin c: myList)
        {
                if (c.getQuantity() > 1 || c.getQuantity() == 0)
                {
                    if (c.getNamepural()
                        .contains("ollar"))
                    {
                        System.out.println("$" + c.getQuantity());
                    } else
                    {
                        System.out.println(c.getQuantity() + " " + c.getNamepural());
                    }
                }

                if (c.getQuantity() == 1)
                {
                    if(c.getName().contains("ollar"))
                    {
                        System.out.println("$" + c.getQuantity());
                    }
                    else
                    {
                    System.out.println(c.getQuantity() + " " + c.getName());
                    }
            }}

        double total = 0;
        for(Coin c : myList)
        {
            total = total + (c.getQuantity() * c.getValue());
        }

        System.out.println("The piggy bank holds " + total);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
