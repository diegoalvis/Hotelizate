import App from '../app'
import Search from '../components/Search'
import Details from '../components/Details'

const Routes = {
    Home: {
        screen: App, 
        navigationOptions: ({navigation}) => ({
            header: false
          })
    },
    Details: {
        screen: Details,
        navigationOptions: ({navigation}) => ({
            header: false
          })
    },
    Search: {
        screen: Search,
        navigationOptions: ({navigation}) => ({
            header: false
        })
    }
}

export default Routes