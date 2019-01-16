package com.sft.Interfaces;

import com.sft.Modals.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by SOFTWARE02 on 15.01.2019.
 */
public interface AccountI {
    public String updateAccount(String senderName, String receiverName, int moneyAmount, int senderAccountId, int receiverAccountId) throws SQLException;
    public List<Account> getAllAccounts();
}
