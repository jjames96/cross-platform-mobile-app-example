import shared

class InjectionImpl : Injection {
    func createAccountPresenter() -> CreateAccountContractPresenter {
        return createAccountPresenter()
    }
    
    func authenticationPresenter() -> AuthenticationContractPresenter {
        return AuthenticationPresenter()
    }
}

let injection = InjectionImpl()
