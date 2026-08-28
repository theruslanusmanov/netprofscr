//
//  ContentView.swift
//  netprofscr
//
//  Created by Ruslan Usmanov on 09.08.2026.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack(alignment: .leading) {
            HStack {
                Text("Net profit")
                    .font(.title)
                Spacer()
                Text("May 9")
            }
            Text("38,915$")
                .font(.largeTitle)
                .bold()
            Spacer()
            HStack(alignment: .bottom) {
                DiagramView(height: 240, title: "Daily revenue", amount: "37,100$")
                DiagramView(height: 120, title: "Daily spend", amount: "12,205$")
                DiagramView(height: 60, title: "Taxes", amount: "16.5%")
            }
            Spacer()
        }
        .padding()
        .foregroundStyle(.black)
        .background(Color(red: 17/255, green: 241/255, blue: 134/255))
    }
}

struct DiagramView: View {
    let height: CGFloat
    let title: String
    let amount: String
    
    var body: some View {
        VStack(alignment: .leading) {
            Text(title)
            Text(amount)
                .font(.title)
                .bold()
            RoundedRectangle(cornerRadius: 24)
                .fill(Color(red: 14/255, green: 35/255, blue: 26/255))
                .frame(height: height)
        }
    }
}

#Preview {
    ContentView()
        .preferredColorScheme(.dark)
}
