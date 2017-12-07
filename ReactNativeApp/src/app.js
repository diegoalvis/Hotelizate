import React, {Component} from 'react'
import {
    Text,
    View,
    StyleSheet,
    ScrollView
} from 'react-native'

import {connect} from 'react-redux'

import Header from './components/Header'
import List from './components/List'
import Menu from './components/Menu'
import Slide from './components/Slider'

import SideMenu from 'react-native-side-menu'

class App extends Component {
    constructor(props){
        super(props)
        this.state = {
            isOpen: false,
            itemSelected: 'Home',
            dataPopular: null,
            data: null,
            result: null
        }
        this.itemSelected = this.itemSelected.bind(this)
    }

    componentDidMount() {
        fetch('http://localhost:3000/hotels')
            .then(res => res.json())
            .then(resJson => {
                this.setState({
                    result: resJson,
                    dataPopular: resJson.slice(0, resJson.length / 3),
                    data: resJson.slice(resJson.length / 3)
            })
        })
    }

    navigationOptions = {
        header: null,  
    }

    toggle(){
        this.setState({
            isOpen: !this.state.isOpen
        })
    }

    itemSelected(item){
        this.setState({
            itemSelected: item,
            isOpen: false
        })
    }

    updateMenu(isOpen){
        this.setState({isOpen})
    }

    render(){
        return (
            <View style={{flex: 1}}>
                <SideMenu
                    menu={<Menu 
                        navigation={this.props.navigation}
                        itemSelected={this.itemSelected} 
                        itemSelectedValue={this.state.itemSelected}
                    />}
                    isOpen={this.state.isOpen}
                    onChange={(isOpen) => this.updateMenu(isOpen)}
                    style={{flex: 1}}
                >
                    <Header itemSelected={this.state.itemSelected} navigation={this.props.navigation} toggle={this.toggle.bind(this)} />
                    <ScrollView style={[{flex: 1}, styles.container]}>
                        {this.state.itemSelected == 'Home' ? <View style={{flex: 1}}>
                            <Slide />
                            <List
                                popularResult={this.state.dataPopular}
                                result={this.state.data}
                                navigation={this.props.navigation}
                            />
                        </View> : 
                        <View />}
                    </ScrollView>
                </SideMenu>
            </View>
        )
    }
}

const styles = StyleSheet.create({
    container: {
        backgroundColor: 'white',
        paddingHorizontal: 8
    }
})

export default connect(state => ({shows: state.shows}))(App)