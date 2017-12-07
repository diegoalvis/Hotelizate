const store = getStore(navReducer);
const AppIndex = connect( state => ({ nav: state.nav }) )(App)

export default Index = () => {
    return (
        <Provider store={store}>
            <AppIndex />
        </Provider>
    )
}