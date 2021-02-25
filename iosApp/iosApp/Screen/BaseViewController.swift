import shared
import UIKit

class BaseViewController : UIViewController, BaseView {
    func closeSelf() {
        // TODO
    }
    
    func showAlert(message: String, positiveAction: AlertAction, negativeAction: AlertAction?) {
        let alertController = UIAlertController(title: nil, message: message, preferredStyle: .alert)
        alertController.addAction(
            UIAlertAction(
                title: positiveAction.actionText,
                style: .default,
                handler: { _ in positiveAction.actionCallback() }
            )
        )
        
        if let action = negativeAction {
            alertController.addAction(
                UIAlertAction(
                    title: action.actionText,
                    style: .cancel,
                    handler: { _ in action.actionCallback() }
                )
            )
        }

        self.present(alertController, animated: true, completion: nil)
    }
    
    func showAlert(message: String) {
        let alertController = UIAlertController(title: nil, message: message, preferredStyle: .alert)
        self.present(alertController, animated: true, completion: nil)
    }
}
