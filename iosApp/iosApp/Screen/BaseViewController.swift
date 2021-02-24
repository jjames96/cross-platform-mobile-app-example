import shared
import UIKit

class BaseViewController : UIViewController, BaseView {
    func closeSelf() {
        // TODO
    }
    
    func showAlert(message: String) {
        let alertController = UIAlertController(title: nil, message: message, preferredStyle: .alert)
        self.present(alertController, animated: true, completion: nil)
    }
}
