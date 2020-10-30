package com.oldduck.home.rich.manager;

import com.oldduck.home.rich.dto.AccountInfoDto;

import java.util.List;

public interface AccountManager {
    List<AccountInfoDto> queryAccountInfo(String userId);
}
