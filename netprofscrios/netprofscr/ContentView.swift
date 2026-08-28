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
        }
        .padding()
        .foregroundStyle(.black)
        .background(.green)
    }
}

#Preview {
    ContentView()
        .preferredColorScheme(.dark)
}
