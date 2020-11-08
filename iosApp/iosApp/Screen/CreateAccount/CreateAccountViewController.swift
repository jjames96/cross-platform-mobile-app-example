import shared
import UIKit

class CreateAccountViewController : BaseViewController {
//    @IBOutlet private weak var createAccountButton: UIButton!
    
    private var presenter: CreateAccountContractPresenter!
    
    override var preferredStatusBarStyle: UIStatusBarStyle {
        return .lightContent
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter = injection.createAccountPresenter()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        presenter.takeView(view: self)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        presenter.dropView()
    }
    
    @IBAction private func textInputsChanged() {
        presenter.textInputsUpdated(accountDetails: getAccountDetails())
    }
    
    @IBAction private func createAccountButtonTapped() {
        presenter.createAccountButtonTapped(accountDetails: getAccountDetails())
    }
    
    @IBAction private func backButtonTapped() {
        closeSelf()
    }
}

extension CreateAccountViewController : CreateAccountContractView {
    func setCreateAccountButtonIsEnabled(isEnabled: Bool) {
//        createAccountButton.isEnabled = isEnabled
    }
}

extension CreateAccountViewController {
    private func getAccountDetails() -> AccountDetails {
        return AccountDetails(username: "", password: "", confirmPassword: "")
    }
}
