import shared

class InjectionImpl : Injection {
    func authenticationPresenter() -> AuthenticationContractPresenter {
        return AuthenticationPresenter()
    }
    
    func createAccountPresenter() -> CreateAccountContractPresenter {
        return CreateAccountPresenter()
    }
}

let injection = InjectionImpl()
