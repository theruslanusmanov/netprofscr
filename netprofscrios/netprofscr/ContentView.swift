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
                RoundedRectangle(cornerRadius: 24)
                    .fill(Color(red: 14/255, green: 35/255, blue: 26/255))
                    .frame(height: 240)
                RoundedRectangle(cornerRadius: 24)
                    .fill(Color(red: 14/255, green: 35/255, blue: 26/255))
                    .frame(height: 120)
                RoundedRectangle(cornerRadius: 24)
                    .fill(Color(red: 14/255, green: 35/255, blue: 26/255))
                    .frame(height: 60)
            }
        }
        .padding()
        .foregroundStyle(.black)
        .background(Color(red: 17/255, green: 241/255, blue: 134/255))
    }
}

#Preview {
    ContentView()
        .preferredColorScheme(.dark)
}
