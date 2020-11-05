import shared

class InjectionImpl : Injection {
    func authenticationPresenter() -> AuthenticationContractPresenter {
        return AuthenticationPresenter()
    }
}

let injection = InjectionImpl()
