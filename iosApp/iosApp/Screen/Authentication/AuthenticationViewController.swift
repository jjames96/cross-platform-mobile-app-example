import shared
import UIKit

class AuthenticationViewController : BaseViewController {
    @IBOutlet private weak var logInButton: UIButton!
    @IBOutlet private weak var usernameTextField: UITextField!
    @IBOutlet private weak var passwordTextField: UITextField!
    
    private var presenter: AuthenticationContractPresenter!
    
    override var preferredStatusBarStyle: UIStatusBarStyle {
        return .lightContent
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter = injection.authenticationPresenter()
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        presenter.takeView(view: self)
    }
    
    @IBAction private func logInButtonTapped() {
        presenter.logInButtonTapped(
            username: usernameTextField.text ?? "",
            password: passwordTextField.text ?? ""
        )
    }
    
    @IBAction private func createAccountButtonTapped() {
        presenter.createAccountButtonTapped(
            populateUsername: usernameTextField.text ?? "",
            populatePassword: passwordTextField.text ?? ""
        )
    }
    
    @IBAction private func forgotPasswordButtonTapped() {
        presenter.forgotPasswordButtonTapped()
    }
    
    @IBAction private func authenticationInputsChanged() {
        presenter.textInputsChanged(
            username: usernameTextField.text ?? "",
            password: passwordTextField.text ?? ""
        )
    }
}

extension AuthenticationViewController : AuthenticationContractView {
    func setLogInButtonEnabled(isEnabled: Bool) {
        logInButton.isEnabled = isEnabled
    }
    
    func goToCreateAccountScreen(populateUsername: String, populatePassword: String) {
        // TODO
    }
}
