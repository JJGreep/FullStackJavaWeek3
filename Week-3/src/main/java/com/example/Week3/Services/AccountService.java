package com.example.Week3.Services;

import com.example.Week3.Models.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AccountService {


    // DB repository mock
    private Map<Long, Account> repository = Arrays.stream(
            new Account[]{
                    new Account(1,"GB33BUKB20201555555555", 1024.34, new String[]{"Jack Sparrow", "Maria Schaap"}),
                    new Account(2,"NL35RABO8233380377", 333.33, new String[]{"Sjaak Afhaak"}),
                    new Account(3, "NL07INGB7114507283", 100000000000.00, new String[]{"Bill Gates"}),
            })
            .collect(Collectors.toConcurrentMap(Account::getId, Function.identity()));

    // DB id sequence mock
    private AtomicLong sequence = new AtomicLong(3);

    public List<Account> readAll() {
        return new ArrayList<>(repository.values());
    }

    public Account read(Long id) {
        return repository.get(id);
    }

    public Account create(Account Account) {
        long key = sequence.incrementAndGet();
        Account.setId(key);
        repository.put(key, Account);
        return Account;
    }

    public Account update(Long id, Account Account) {
        Account.setId(id);
        Account oldAccount = repository.replace(id, Account);
        return oldAccount == null ? null : Account;
    }

    public void delete(Long id) {
        repository.remove(id);
    }
}