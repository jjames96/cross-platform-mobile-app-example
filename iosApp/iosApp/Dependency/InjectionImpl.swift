import shared

class InjectionImpl : Injection {
    func authenticationPresenter() -> AuthenticationContractPresenter {
        return AuthenticationPresenter()
    }
    
    func createAccountPresenter() -> CreateAccountContractPresenter {
        return createAccountPresenter()
    }
}

let injection = InjectionImpl()
